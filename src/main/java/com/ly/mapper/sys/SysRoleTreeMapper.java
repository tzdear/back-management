package com.ly.mapper.sys;

import com.ly.po.SysRoleTree;

public interface SysRoleTreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleTree record);

    int insertSelective(SysRoleTree record);

    SysRoleTree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleTree record);

    int updateByPrimaryKey(SysRoleTree record);

	/**
	 * @Title: deleteByRoleId
	 * @author: linyan
	 * @Description: 
	 * @param valueOf
	*/
	void deleteByRoleId(Integer roleid);
}