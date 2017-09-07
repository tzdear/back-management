package com.ly.service.sys;

import java.util.List;
import java.util.Map;

import com.ly.po.SysRole;

/**
* @ClassName: ISysRoleService
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:31:22
*
*/
public interface ISysRoleService {

	/**
	 * @Title: selectRoleByUserId
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	List<SysRole> selectRoleByUserId(Integer id);

	/**
	 * @Title: ajaxTableRolePage
	 * @author: linyan
	 * @Description: 
	 * @param pare
	 * @return
	*/
	Map<String, Object> ajaxTableRolePage(Map<String, Object> pare);

	/**
	 * @Title: selectAllRole
	 * @author: linyan
	 * @Description: 
	 * @return
	*/
	Map<String, Object> selectAllRole();

	/**
	 * @Title: selectRoleBySysUser
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	Map<String, Object> selectRoleBySysUser(Integer id);

	/**
	 * @Title: addOrEditRole
	 * @author: linyan
	 * @Description: 
	 * @param sysRole
	 * @return
	*/
	Map<String, Object> addOrEditRole(SysRole sysRole);

	/**
	 * @Title: editRoleTree
	 * @author: linyan
	 * @Description: 
	 * @param treeids
	 * @param roleid
	 * @return
	*/
	Map<String, Object> editRoleTree(String[] treeids, String roleid);

	/**
	 * @Title: deleteRoleObject
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	Map<String, Object> deleteRoleObject(Integer id);

}
