package com.ly.service.sys.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.mapper.sys.SysTreeMapper;
import com.ly.po.SysRole;
import com.ly.po.SysTree;
import com.ly.service.sys.ISysTreeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: SysTreeServiceImpl
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:35:54
*
*/
@Service
public class SysTreeServiceImpl implements ISysTreeService {

	@Autowired
	private SysTreeMapper sysTreeMapper;
	
	
	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#selectTreeByRoleIds(java.util.List)
	 */
	public List<SysTree> selectTreeByRoleIds(List<SysRole> list) {
		Set<SysTree> re = new HashSet<SysTree>();
		for (SysRole sysRole : list) {
			List<SysTree> aList = sysTreeMapper.selectTreeByRoleId(sysRole.getId());
			re.addAll(aList);
		}
		List<SysTree> result = new ArrayList<SysTree>();
		result.addAll(re);
		return result;
	}

	public List<Map<String, Object>> lvTree(List<SysTree> trees,List<SysTree> perList , Integer parentId){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (SysTree sysTree : trees) {
			if(sysTree.getParentId()==parentId){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", sysTree.getId());
				map.put("icon", sysTree.getTreeIcon());
				map.put("text", sysTree.getChName());
				map.put("data", "");
				map.put("type", "");
				map.put("order", sysTree.getTreeOrder());
				Map<String, Object> state = new HashMap<String, Object>();
				state.put("opened", true);
				map.put("state", state);//selected opened checked
				for (SysTree perSysTree : perList) {
					if (perSysTree.getId()==sysTree.getId()) {
						state.put("selected", true);
						map.put("state", state);//selected opened checked
					}
				}
				List<Map<String, Object>> chil = lvTree(trees,perList,sysTree.getId());
				map.put("children", chil);
				list.add(map);
			}
		}
		Collections.sort(list,new Comparator<Map<String, Object>>() {
			/*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				Integer a = Integer.valueOf(o1.get("order").toString());
				Integer b = Integer.valueOf(o2.get("order").toString());
				if (a>b) {
					return 1;
				}else if (a<b) {
					return -1;
				}
				return 0;
			}
			
		});
		return list;
	}
	
	
	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#giveRoleTree(java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> giveRoleTree(Integer id) {
		List<SysTree> list = sysTreeMapper.selectAllTree();
		
		List<SysTree> perList = sysTreeMapper.selectTreeByRoleId(id);
		List<Map<String, Object>> reList = new ArrayList<Map<String,Object>>();
		reList = lvTree(list,perList,0);
		return reList;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#selectTreeByTreeNo(java.lang.Integer)
	 */
	@Override
	public List<SysTree> selectTreeByTreeNo(Integer treeNo) {
		List<SysTree> perList = sysTreeMapper.selectTreeByTreeNo(treeNo);
		return perList;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#selectAllTree()
	 */
	@Override
	public List<Map<String, Object>> selectAllTree() {
		List<SysTree> list = sysTreeMapper.selectAllTree();
		List<Map<String, Object>> listMaps = shu(list, 0);
		return listMaps;
	}
	
	public List<Map<String, Object>> shu(List<SysTree> listTrees,Integer treeParendId){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (SysTree sysTree : listTrees) {
			if (sysTree.getParentId()==treeParendId) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id",sysTree.getId());
				map.put("title", sysTree.getChName());
				map.put("icon", sysTree.getTreeIcon());
				map.put("order", sysTree.getTreeOrder());
				map.put("children", shu(listTrees,sysTree.getId()));
				list.add(map);
			}
		}
		Collections.sort(list,new Comparator<Map<String, Object>>() {
			/*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				Integer a = Integer.valueOf(o1.get("order").toString());
				Integer b = Integer.valueOf(o2.get("order").toString());
				if (a>b) {
					return 1;
				}else if (a<b) {
					return -1;
				}
				return 0;
			}
			
		});
		return list;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#selectOneById(java.lang.Integer)
	 */
	@Override
	public SysTree selectOneById(Integer id) {
		SysTree sysTree = sysTreeMapper.selectByPrimaryKey(id);
		return sysTree;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#updateTree(java.lang.String)
	 */
	@Transactional
	@Override
	public Map<String, Object> updateTree(String treeIdOrder) {
		JSONArray js = JSONArray.fromObject(treeIdOrder);
		xun(js,0,1);
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}
	
	
	public void xun(JSONArray jsonArray,Integer f,Integer treeNo){
		int a = jsonArray.size();
		for (int i = 0; i < a; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Integer id = jsonObject.getInt("id");
			System.out.println(id+"<><><><><><><><>"+f+"<<<<<<>>>>>>>>>>"+i);
			SysTree sysTree = new SysTree();
			sysTree.setId(id);
			sysTree.setParentId(f);
			sysTree.setTreeNo(treeNo);
			sysTree.setTreeOrder(""+(i+1));
			sysTreeMapper.updateByPrimaryKeySelective(sysTree);
			boolean isChildren = jsonObject.containsKey("children");
			if (isChildren) {
				JSONArray jsonArray2 = jsonObject.getJSONArray("children");
				xun(jsonArray2,id,treeNo+1);
			}
		}
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#addOrUpdateTree(com.ly.po.SysTree)
	 */
	@Override
	public void addOrUpdateTree(SysTree sysTree) {
		Integer id = sysTree.getId();
		if (sysTree.getParentId()==null) {
			sysTree.setParentId(0);
		}
		Integer parentId = sysTree.getParentId();
		List<SysTree> list = sysTreeMapper.selectByTreeParentId(parentId);
		int order = 1;
		if (list!=null&&list.size()>0) {
			order = list.size()+1;
		}
		sysTree.setTreeNo(sysTree.getTreeNo()+1);
		sysTree.setTreeOrder(""+order);
		if (id==null||id==0) {//add
			id = sysTreeMapper.insertSelective(sysTree);
			sysTree.setId(id);
		}else {//update
			sysTreeMapper.updateByPrimaryKeySelective(sysTree);
		}
		System.out.println(parentId);
		System.out.println(sysTree.getTreeNo());
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysTreeService#deleteTree(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> deleteTree(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		sysTreeMapper.deleteByPrimaryKey(id);
		return map;
	}
	
	
}
