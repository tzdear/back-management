package com.ly.mapper.sys;

import com.ly.po.SysHisLoginUser;

public interface SysHisLoginUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysHisLoginUser record);

    int insertSelective(SysHisLoginUser record);

    SysHisLoginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysHisLoginUser record);

    int updateByPrimaryKey(SysHisLoginUser record);
}