package com.ly.service.sys.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.common.LyPage;
import com.ly.common.LyPagePlugin;
import com.ly.mapper.sys.SysUserMapper;
import com.ly.mapper.sys.SysUserRoleMapper;
import com.ly.po.SysUser;
import com.ly.po.SysUserRole;
import com.ly.service.sys.ISysUserService;

/**
* @ClassName: SysUserServiceImpl
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:36:27
*
*/
@Service
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysUserService#selectPageSysUser(com.ly.common.LyPage)
	 */
	@SuppressWarnings("unchecked")
	public LyPage<SysUser> selectPageSysUser(LyPage<SysUser> page) {
		SysUser sysUser = new SysUser();
		LyPagePlugin.startPage(0, 10);
		sysUserMapper.selectPageSysUser(sysUser);
		page = LyPagePlugin.endPage();
		System.out.println(page);
		return page;
	}


	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysUserService#updateSysUserRole(java.lang.String[], java.lang.String)
	 */
	@Override
	public Map<String, Object> updateSysUserRole(String[] roleIds, String sysuserid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			sysUserRoleMapper.deleteBySysUserId(Integer.valueOf(sysuserid));
			for (int i = 0; i < roleIds.length; i++) {
				SysUserRole sysuserrole = new SysUserRole();
				sysuserrole.setSysRole(Integer.valueOf(roleIds[i]));
				sysuserrole.setSysUserId(Integer.valueOf(sysuserid));
				sysUserRoleMapper.insertSelective(sysuserrole);
			}
			map.put("code", 0);
		} catch (Exception e) {
			map.put("code", 0);
			map.put("mes", "出错了");
			e.printStackTrace();
		}
		return map;
	}


	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysUserService#resetPass(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> resetPass(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
			sysUser.setUserPass("123456");
			int a = sysUserMapper.updateByPrimaryKeySelective(sysUser);
			if (a==0) {
				map.put("code",1);
				map.put("mes", "修改失败了");
			}else {
				map.put("code", 0);
				map.put("mes","");
			}
		} catch (Exception e) {
			map.put("code", 1);
			map.put("mes","出错了");
			e.printStackTrace();
		}
		return map;
	}


	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysUserService#deleteSysUser(java.lang.Integer)
	 */
	@Transactional
	@Override
	public Map<String, Object> deleteSysUser(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
			int a = sysUserMapper.deleteByPrimaryKey(id);
			if (a==0) {
				map.put("code",1);
				map.put("mes", "您要删除的对象不存在");
			}else {
				sysUserRoleMapper.deleteBySysUserId(id);
				map.put("code", 0);
				map.put("mes", "");
			}
		return map;
	}

}
