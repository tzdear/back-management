package com.ly.service.sys;

import java.util.List;
import java.util.Map;

import com.ly.po.SysRole;
import com.ly.po.SysTree;

/**
* @ClassName: ISysTreeService
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:33:39
*
*/
public interface ISysTreeService {

	/**
	 * @Title: selectTreeByRoleIds
	 * @author: linyan
	 * @Description: 
	 * @param list
	 * @return
	*/
	List<SysTree> selectTreeByRoleIds(List<SysRole> list);

	/**
	 * @Title: giveRoleTree
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	List<Map<String, Object>> giveRoleTree(Integer id);

	/**
	 * @Title: getTreeByTreeNo
	 * @author: linyan
	 * @Description: 
	 * @param treeNo
	 * @return
	*/
	List<SysTree> selectTreeByTreeNo(Integer treeNo);

	/**
	 * @Title: selectAllTree
	 * @author: linyan
	 * @Description: 
	 * @return
	*/
	List<Map<String, Object>> selectAllTree();

	/**
	 * @Title: selectOneById
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	SysTree selectOneById(Integer id);

	/**
	 * @Title: updateTree
	 * @author: linyan
	 * @Description: 
	 * @param treeIdOrder
	 * @return
	*/
	Map<String, Object> updateTree(String treeIdOrder);

	/**
	 * @Title: addOrUpdateTree
	 * @author: linyan
	 * @Description: 
	 * @param sysTree
	*/
	void addOrUpdateTree(SysTree sysTree);

	/**
	 * @Title: deleteTree
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	Map<String, Object> deleteTree(Integer id);

}
