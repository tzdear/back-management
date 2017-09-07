package com.ly.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.crazycake.shiro.RedisManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ly.po.SysRole;
import com.ly.po.SysTree;
import com.ly.po.SysUser;
import com.ly.service.shior.IShiorUserService;

/**
* @ClassName: DefaultWebServiceRealm
* @Description: 
* @author linyan
* @date 2017年7月15日 下午12:15:03
*
*/
public class DefaultWebServiceRealm extends AuthorizingRealm {

	private static final String SESSION_USER_KEY = "user:session:key";
	
	private IShiorUserService shiorUserService;
	
	private RedisManager redisManager;
	
	/* （非 Javadoc）
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Map<String, Object> map = (Map<String, Object>)principals.getPrimaryPrincipal();
//		SysUser sysUser = (SysUser)map.get("user");
		System.err.println("进入 doGetAuthorizationInfo  ============");
		List<SysRole> roles = (List<SysRole>)map.get("roles");
		List<SysTree> trees = (List<SysTree>)map.get("prems");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysTree sysTree : trees) {
        	if (sysTree.getTreeUrl()!=null&&!sysTree.getTreeUrl().trim().equals("")) {
        		info.addStringPermission(sysTree.getTreeUrl()); 
			}
		}
        for (SysRole sysRole : roles) {
        	info.addRole(sysRole.getRoleName()); 
		}
        System.out.println("shior 是第几个？？？？？？？？？？？？？？？？？？？？？？？？？？？？？==============？");
        return info;
	}

	/* （非 Javadoc）
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authToken = (UsernamePasswordToken) token;
		String userName =  authToken.getUsername();  
	    String password = String.valueOf(authToken.getPassword());
	    System.err.println("进入 AuthenticationInfo  ============");
	    SysUser sysUwser = shiorUserService.selectSysUserByUserName(userName);
	    if (sysUwser==null) {
			return null;
		}
	    SysUser sysUser = shiorUserService.selectSysUserByUserNameAndPass(userName,password);
	    if (sysUser==null) {
			throw new IndexOutOfBoundsException("密码错误");
		}
	    Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(SESSION_USER_KEY, sysUser); 
        
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(SESSION_USER_KEY, sysUser);
        
        List<SysRole> roles = shiorUserService.selectSysRoleByUserId(sysUser.getId());
        List<SysTree> trees = shiorUserService.selectSysTreeByRoleIds(roles);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", sysUser);
        map.put("roles", roles);
        map.put("prems", trees);
        SimpleAuthenticationInfo info =  new SimpleAuthenticationInfo(map, password, getName()); 
        System.out.println("shior 是第几个？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？");
        return info;
	}

	public IShiorUserService getShiorUserService() {
		return shiorUserService;
	}

	public void setShiorUserService(IShiorUserService shiorUserService) {
		this.shiorUserService = shiorUserService;
	}

	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	
	
}
