package com.ly.controller.sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.po.SysRole;
import com.ly.po.SysTree;
import com.ly.po.SysUser;
import com.ly.service.sys.ISysRoleService;
import com.ly.service.sys.ISysTreeService;
import com.ly.service.sys.ISysUserService;

/**
* @ClassName: SysMenuController
* @Description: 
* @author linyan
* @date 2017年7月15日 上午11:03:03
*
*/
@SuppressWarnings({ "unused" })
@Controller
public class SysMenuController {

	private static final String SESSION_USER_KEY = "user:session:key";
	
	@Autowired
	private ISysTreeService sysTreeService;
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	@RequestMapping(value = "getMenu")
	@ResponseBody
	public Object getMenu(HttpServletRequest request,HttpServletResponse response){
		SysUser user = (SysUser)request.getSession().getAttribute(SESSION_USER_KEY);
		
		List<SysRole> list = sysRoleService.selectRoleByUserId(user.getId());
		
		List<SysTree> trees = sysTreeService.selectTreeByRoleIds(list);
		
		List<Map<String, Object>> banM = lvMenu(trees,0);
		
		return banM;
	}
	
	public List<Map<String, Object>> lvMenu(List<SysTree> trees,Integer parentId){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (SysTree sysTree : trees) {
			if(sysTree.getParentId()==parentId&&sysTree.getTreeType().equals("1")){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("url", sysTree.getTreeUrl());
				map.put("name", sysTree.getChName());
				map.put("icon", sysTree.getTreeIcon());
				map.put("parentId", sysTree.getParentId());
				map.put("order", sysTree.getTreeOrder());
				List<Map<String, Object>> chil = lvMenu(trees,sysTree.getId());
				map.put("chilens", chil);
				list.add(map);
			}
		}
		Collections.sort(list,new Comparator<Map<String, Object>>() {
			/*  
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，  
             * 返回负数表示：o1 小于o2，  
             * 返回0 表示：o1和o2相等，  
             * 返回正数表示：o1大于o2。  
             */  
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				Integer a = Integer.valueOf(o1.get("order").toString());
				Integer b = Integer.valueOf(o2.get("order").toString());
				if (a>b) {
					return 1;
				}else if (a<b) {
					return -1;
				}
				return 0;
			}
			
		});
		return list;
	}
	
}
