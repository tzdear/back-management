package com.ly.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

/**
* @ClassName: LyPagePlugin
* @Description: 
* @author linyan
* @date 2017年7月17日 下午2:55:14
*
*/
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class}),
			@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class LyPagePlugin implements Interceptor {
	
	private String pageSqlId = "page";
	
	public static final ThreadLocal<LyPage> localPage = new ThreadLocal<LyPage>();  
	
	 public static void startPage(int fist, int end) {
		 LyPage ly = new LyPage();
		 ly.setFirst(fist);
		 ly.setEnd(end);
        localPage.set(ly);  
    }  
	
	 public static LyPage endPage() {  
		 LyPage page = localPage.get();  
        localPage.remove();  
        return page;  
    }  
	
	/* （非 Javadoc）
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	public Object intercept(Invocation ivk) throws Throwable {
		if(ivk.getTarget() instanceof RoutingStatementHandler){
			//拦截到的目标对象：RoutingStatementHandler对象
            RoutingStatementHandler statementHandler = (RoutingStatementHandler)ivk.getTarget();
          //通过反射获取到当前RoutingStatementHandler对象的delegate属性
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
            if(mappedStatement.getId().toLowerCase().indexOf(pageSqlId)>0){ //拦截需要分页的SQL
            	//获取到当前StatementHandler的 boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的
                BoundSql boundSql = delegate.getBoundSql();
              //拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
                Object parameterObject = boundSql.getParameterObject();//分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
                if(parameterObject==null){
                    throw new NullPointerException("parameterObject尚未实例化(也就是在mapper中没有parameterType 或 parameterMap )！");
                }else{
                    //拦截到的prepare方法参数是一个Connection对象
                    Connection connection = (Connection) ivk.getArgs()[0];
                    //获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
                    String sql = boundSql.getSql();
                    //String countSql = "select count(0) from (" + sql+ ") as tmp_count"; //记录统计
                    String countSql = "select count(0) from (" + sql+ ")  tmp_count"; //记录统计 == oracle 加 as 报错(SQL command not properly ended)
                    //记录统计
                    PreparedStatement countStmt = connection.prepareStatement(countSql);
                    BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),countSql,boundSql.getParameterMappings(),parameterObject);
                    setParameters(countStmt,mappedStatement,countBS,parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    int count = 0;
                    if (rs.next()) {
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();
                    //System.out.println(count);
                    LyPage page = localPage.get();
                    //给当前的page参数对象设置总记录数
                    page.setTotal(count);
                    //获取分页Sql语句
                    String pageSql = generatePageSql(sql,page);
                    //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
                    if (page.getEnd()<=0) {
                    	ReflectHelper.setValueByFieldName(boundSql, "sql", sql); //将分页sql语句反射回BoundSql.
					}else {
						ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); //将分页sql语句反射回BoundSql.
					}
                }
            }
            Object se  =  ivk.proceed();
            return se;
		}else if (ivk.getTarget() instanceof ResultSetHandler) {
			Object result = ivk.proceed();  
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(ivk.getTarget(), "mappedStatement");
			BoundSql boundSql = (BoundSql) ReflectHelper.getValueByFieldName(ivk.getTarget(), "boundSql");
			if(mappedStatement.getId().toLowerCase().indexOf(pageSqlId)>0){ //拦截需要分页的SQL
				LyPage page = localPage.get();
                page.setData((List)result);
			}
            return result;  
		}
		return ivk.proceed();
	}
	
	/**
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null) {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                        }
                    } else {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {
                        throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
                }
            }
        }
    }
	
    /**
     * 根据数据库方言，生成特定的分页sql
     * @param sql
     * @param page
     * @return
     */
    private String generatePageSql(String sql,LyPage page){
        if(page!=null){
            StringBuffer pageSql = new StringBuffer();
            pageSql.append(sql);
            pageSql.append(" limit "+page.getFirst()+","+page.getEnd());
            return pageSql.toString();
        }else{
            return sql;
        }
    }

    
	/* （非 Javadoc）
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	/**
     * 拦截器对应的封装原始对象的方法
     * @param arg0
     * @return
     */
	public Object plugin(Object target) {
		 if (target instanceof StatementHandler || target instanceof ResultSetHandler) {  
            return Plugin.wrap(target, this);  
        } else {  
            return target;  
        }  
	}
	
	/* （非 Javadoc）
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	/**
     * 设置注册拦截器时设定的属性
     * @param p
     */
	public void setProperties(Properties arg0) {
	}
	
}
