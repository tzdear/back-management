package com.ly.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.po.SysRole;
import com.ly.service.sys.ISysRoleService;

/**
* @ClassName: SysRoleController
* @Description: 
* @author linyan
* @date 2017年7月16日 下午7:06:21
*
*/
@Controller
public class SysRoleController {

	@Autowired
	private ISysRoleService sysRoleService;
	
	@RequestMapping(value="role")
	public String goToRole(HttpServletRequest request,HttpServletResponse response){
		return "sys/role";
	}
	
	@RequestMapping(value = "ajaxTableRole" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object ajaxTable(HttpServletRequest request,HttpServletResponse response){
		Integer roleId = ServletRequestUtils.getIntParameter(request, "roleId",0);
		String roleName = ServletRequestUtils.getStringParameter(request, "roleName",null);
		String draw = ServletRequestUtils.getStringParameter(request,"draw",null);
		String orderDir = ServletRequestUtils.getStringParameter(request,"order[0][dir]",null);
		Integer start = ServletRequestUtils.getIntParameter(request, "start",0);
		Integer length = ServletRequestUtils.getIntParameter(request, "length",0);
		Integer order = ServletRequestUtils.getIntParameter(request, "order[0][column]",0);
		Map<String, Object> pare = new HashMap<String, Object>();
		pare.put("draw", draw);
		pare.put("orderDir", orderDir);
		pare.put("start", start);
		pare.put("length", length);
		pare.put("order", order);
		pare.put("roleId", roleId);
		pare.put("roleName", roleName);
		Map<String, Object> map = new HashMap<String, Object>();
		map = sysRoleService.ajaxTableRolePage(pare);
		return map;
	}
	
	@RequestMapping(value = "selectRoleBySysUser" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object selectRoleBySysUser(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		map = sysRoleService.selectRoleBySysUser(id);
		return map;
	}
	
	@RequestMapping(value = "addOrEditRole")
	@ResponseBody
	public Object addOrEditRole(String roleName,String sysroleid ,String roleid, HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		SysRole sysRole = new SysRole();
		sysRole.setId(Integer.valueOf(sysroleid==null||sysroleid.equals("")?"0":sysroleid));
		sysRole.setRoleName(roleName);
		map = sysRoleService.addOrEditRole(sysRole);
//		map.put("code", 0);
//		map.put("mes", "");
//		map.put("reDate", "");
		return map;
	}
	
	@RequestMapping(value = "editRoleTree" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object editRoleTree(@RequestParam(value = "treeids[]") String[] treeids,String roleid){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = sysRoleService.editRoleTree(treeids,roleid);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes","修改权限出现了错误。");
		}
		return map;
	}
	
	@RequestMapping(value= "deleteRole")
	@ResponseBody
	public Object deleteRoleObject(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = sysRoleService.deleteRoleObject(id);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes","删除权限出现了错误。");
		}
		
//		map.put("code", 0);
//		map.put("mes", 0);
//		map.put("reDate", 0);
		return map;
	}
	
}
