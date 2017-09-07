package com.ly.service.shior;

import java.util.List;

import com.ly.po.SysRole;
import com.ly.po.SysTree;
import com.ly.po.SysUser;

/**
* @ClassName: ShiorUserService
* @Description: 
* @author linyan
* @date 2017年7月15日 下午12:03:49
*
*/
public interface IShiorUserService {

	/**
	 * @Title: selectSysUserByUserName
	 * @author: linyan
	 * @Description: 
	 * @return
	*/
	SysUser selectSysUserByUserName(String userName);

	/**
	 * @Title: selectSysRoleByUserId
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	List<SysRole> selectSysRoleByUserId(Integer id);

	/**
	 * @Title: selectSysTreeByRoleIds
	 * @author: linyan
	 * @Description: 
	 * @param roles
	 * @return
	*/
	List<SysTree> selectSysTreeByRoleIds(List<SysRole> roles);

	/**
	 * @Title: selectSysUserByUserNameAndPass
	 * @author: linyan
	 * @Description: 
	 * @param userName
	 * @param password
	 * @return
	*/
	SysUser selectSysUserByUserNameAndPass(String userName, String password);

}
