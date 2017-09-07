package com.ly.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.mapper.sys.SysLoginUserMapper;
import com.ly.service.sys.ISysLoginUserService;

/**
* @ClassName: SysLoginUserServiceImpl
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:34:50
*
*/
@Service
public class SysLoginUserServiceImpl implements ISysLoginUserService{

	@SuppressWarnings("unused")
	@Autowired
	private SysLoginUserMapper sysLoginUserMapper;
	
}
