package com.ly.service.sys;

import java.util.Map;

import com.ly.common.LyPage;
import com.ly.po.SysUser;

/**
* @ClassName: ISysUserService
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:31:44
*
*/
public interface ISysUserService {

	LyPage<SysUser> selectPageSysUser(LyPage<SysUser> page);

	/**
	 * @Title: updateSysUserRole
	 * @author: linyan
	 * @Description: 
	 * @param roleIds
	 * @param sysuserid
	 * @return
	*/
	Map<String, Object> updateSysUserRole(String[] roleIds, String sysuserid);

	/**
	 * @Title: resetPass
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	Map<String, Object> resetPass(Integer id);

	/**
	 * @Title: deleteSysUser
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	Map<String, Object> deleteSysUser(Integer id);
	
}
