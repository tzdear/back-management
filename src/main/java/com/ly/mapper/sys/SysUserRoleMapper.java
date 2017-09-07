package com.ly.mapper.sys;

import com.ly.po.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

	/**
	 * @Title: selectByRoleAndUserId
	 * @author: linyan
	 * @Description: 
	 * @param sysuserrole
	 * @return
	*/
	SysUserRole selectByRoleAndUserId(SysUserRole sysuserrole);

	/**
	 * @Title: deleteBySysUserId
	 * @author: linyan
	 * @Description: 
	 * @param sysuserid
	*/
	void deleteBySysUserId(Integer sysuserid);

	/**
	 * @Title: deleteBySysRole
	 * @author: linyan
	 * @Description: 
	 * @param id
	*/
	void deleteBySysRole(Integer id);
}