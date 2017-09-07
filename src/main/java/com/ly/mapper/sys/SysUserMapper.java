package com.ly.mapper.sys;

import java.util.List;
import java.util.Map;

import com.ly.po.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	/**
	 * @Title: selectSysUserByUserName
	 * @author: linyan
	 * @Description: 
	 * @param userName
	 * @return
	*/
	SysUser selectSysUserByUserName(String userName);

	/**
	 * @Title: selectSysUserByUserNameAndPass
	 * @author: linyan
	 * @Description: 
	 * @param map
	 * @return
	*/
	SysUser selectSysUserByUserNameAndPass(Map<String, String> map);
	
	List<SysUser> selectPageSysUser(SysUser sysUser);

}