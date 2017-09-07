package com.ly.mapper.sys;

import com.ly.po.SysLoginUser;

public interface SysLoginUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLoginUser record);

    int insertSelective(SysLoginUser record);

    SysLoginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLoginUser record);

    int updateByPrimaryKey(SysLoginUser record);
}