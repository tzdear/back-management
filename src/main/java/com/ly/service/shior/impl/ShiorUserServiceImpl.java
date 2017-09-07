package com.ly.service.shior.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.mapper.sys.SysUserMapper;
import com.ly.po.SysRole;
import com.ly.po.SysTree;
import com.ly.po.SysUser;
import com.ly.service.shior.IShiorUserService;
import com.ly.service.sys.ISysRoleService;
import com.ly.service.sys.ISysTreeService;

/**
* @ClassName: ShiorUserServiceImpl
* @Description: 
* @author linyan
* @date 2017年7月15日 下午12:04:13
*
*/
@Service
public class ShiorUserServiceImpl implements IShiorUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private ISysTreeService sysTreeService;
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	
	/* （非 Javadoc）
	 * @see com.ly.service.shior.IShiorUserService#selectSysUserByUserName()
	 */
	public SysUser selectSysUserByUserName(String userName) {
		SysUser sysUser  = sysUserMapper.selectSysUserByUserName(userName);
		return sysUser;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.shior.IShiorUserService#selectSysRoleByUserId(java.lang.Integer)
	 */
	public List<SysRole> selectSysRoleByUserId(Integer id) {
		List<SysRole> list = sysRoleService.selectRoleByUserId(id);
		return list;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.shior.IShiorUserService#selectSysTreeByRoleIds(java.util.List)
	 */
	public List<SysTree> selectSysTreeByRoleIds(List<SysRole> roles) {
		List<SysTree> trees = sysTreeService.selectTreeByRoleIds(roles);
		return trees;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.shior.IShiorUserService#selectSysUserByUserNameAndPass(java.lang.String, java.lang.String)
	 */
	public SysUser selectSysUserByUserNameAndPass(String userName, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", userName);
		map.put("password", password);
		return sysUserMapper.selectSysUserByUserNameAndPass(map);
	}
	
}
