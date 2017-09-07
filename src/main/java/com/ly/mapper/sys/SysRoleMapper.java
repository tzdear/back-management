package com.ly.mapper.sys;

import java.util.List;
import java.util.Map;

import com.ly.po.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

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
	*/
	List<SysRole> ajaxTableRolePage(Map<String, Object> pare);

	/**
	 * @Title: selectAllRole
	 * @author: linyan
	 * @Description: 
	 * @return
	*/
	List<SysRole> selectAllRole();

	/**
	 * @Title: selectRoleBySysUser
	 * @author: linyan
	 * @Description: 
	 * @param id
	 * @return
	*/
	List<SysRole> selectRoleBySysUser(Integer id);
}