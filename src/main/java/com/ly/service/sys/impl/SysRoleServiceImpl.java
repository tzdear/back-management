package com.ly.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.common.LyPage;
import com.ly.common.LyPagePlugin;
import com.ly.mapper.sys.SysRoleMapper;
import com.ly.mapper.sys.SysRoleTreeMapper;
import com.ly.mapper.sys.SysUserRoleMapper;
import com.ly.po.SysRole;
import com.ly.po.SysRoleTree;
import com.ly.service.sys.ISysRoleService;

/**
* @ClassName: SysRoleServiceImpl
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:35:20
*
*/
@Service
public class SysRoleServiceImpl implements ISysRoleService {

	
	@Autowired
	private SysRoleTreeMapper sysRoleTreeMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#selectRoleByUserId(java.lang.Integer)
	 */
	public List<SysRole> selectRoleByUserId(Integer id) {
		return sysRoleMapper.selectRoleByUserId(id);
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#ajaxTableRolePage(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> ajaxTableRolePage(Map<String, Object> pare) {
		LyPagePlugin.startPage(Integer.valueOf(pare.get("start").toString()),Integer.valueOf(pare.get("length").toString()) + Integer.valueOf(pare.get("start").toString()) - 1);
		sysRoleMapper.ajaxTableRolePage(pare);
		LyPage<SysRole> page = LyPagePlugin.endPage();
		List<List<Object>> list = new ArrayList<List<Object>>();
		for (SysRole sysRole : page.getData()) {
			List<Object> row = new ArrayList<Object>();
			row.add(sysRole.getId());
			row.add(sysRole.getRoleName());
			row.add("<a href=\"javascript:;\" class=\"btn btn-sm btn-outline grey-salsa editroleclass\" data-id=\""+sysRole.getId()+"\" data-name=\""+sysRole.getRoleName()+"\"><i class=\"fa fa-search\"></i>修改</a>"+
					"<a href=\"javascript:;\" class=\"btn btn-sm btn-outline grey-salsa deleteroleclass\" data-id=\""+sysRole.getId()+"\"><i class=\"fa fa-search\"></i>删除</a>"+
					"<a href=\"javascript:;\" class=\"btn btn-sm btn-outline grey-salsa giveperclass\" data-id=\""+sysRole.getId()+"\"><i class=\"fa fa-search\"></i>分配权限</a>");
			list.add(row);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draw", pare.get("draw"));
		map.put("recordsFiltered", page.getTotal());
		map.put("recordsTotal", page.getTotal());
		map.put("data", list);
		return map;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#selectAllRole()
	 */
	@Override
	public Map<String, Object> selectAllRole() {
		
		return null;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#selectRoleBySysUser(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> selectRoleBySysUser(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SysRole> roles = sysRoleMapper.selectRoleBySysUser(id);
			List<SysRole> roles2 = sysRoleMapper.selectAllRole();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			for (SysRole sysRole : roles2) {
				Map<String, Object> re = new HashMap<String, Object>();
				re.put("name", sysRole.getRoleName());
				re.put("value", sysRole.getId());
				re.put("selected", false);
				for (SysRole sysRole1 : roles) {
					if (sysRole.getId()==sysRole1.getId()) {
						re.put("selected", true);
					}
				}
				list.add(re);
			}
			map.put("code", 0);
			map.put("mes", 0);
			map.put("reData",list);
		} catch (Exception e) {
			map.put("code", 1);
			map.put("mes", "出错了");
			e.printStackTrace();
		}
		return map;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#addOrEditRole(com.ly.po.SysRole)
	 */
	@Override
	public Map<String, Object> addOrEditRole(SysRole sysRole) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			if (sysRole!=null&&sysRole.getRoleName()!=null&&!sysRole.getRoleName().trim().equals("")) {
				if (sysRole.getId()==null||sysRole.getId()==0) {
					//添加
					int id = sysRoleMapper.insertSelective(sysRole);
					if (id!=0) {
						sysRole.setId(id);
						map.put("code",0);
						map.put("mes", "");
					}else {
						map.put("code",4);
						map.put("mes", "添加失败了");
					}
				}else {
					//修改
					int a = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
					if (a==0) {
						map.put("code",3);
						map.put("mes", "添加失败了");
					}else {
						map.put("code",0);
						map.put("mes", "");
					}
				}
			}else {
				map.put("code",2);
				map.put("mes", "没有对象吖");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes", "出现错误了、");
		}
		return map;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#editRoleTree(java.lang.String[], java.lang.String)
	 */
	@Transactional
	@Override
	public Map<String, Object> editRoleTree(String[] treeids, String roleid) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (roleid!=null&&roleid!=""&&!roleid.trim().equals("")&&!roleid.trim().equals("0")&&treeids!=null&&treeids.length>0) {
			sysRoleTreeMapper.deleteByRoleId(Integer.valueOf(roleid));
			for (String string : treeids) {
				SysRoleTree sysRoleTree = new SysRoleTree();
				sysRoleTree.setSysRoleId(Integer.valueOf(roleid));
				sysRoleTree.setSysTreeId(Integer.valueOf(string));
				sysRoleTreeMapper.insertSelective(sysRoleTree);
			}
			map.put("code", 0);
			map.put("mes", "");
		}else {
			map.put("code", 1);
			map.put("mes", "您没有传值");
		}
		return map;
	}

	/* （非 Javadoc）
	 * @see com.ly.service.sys.ISysRoleService#deleteRoleObject(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> deleteRoleObject(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id!=null&&id!=0) {
			sysRoleMapper.deleteByPrimaryKey(id);
			sysUserRoleMapper.deleteBySysRole(id);
		}else {
			map.put("code", 1);
			map.put("mes", "您传的值为空");
		}
		return map;
	}

}
