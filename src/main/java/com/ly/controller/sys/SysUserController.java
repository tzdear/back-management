package com.ly.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.common.LyPage;
import com.ly.po.SysUser;
import com.ly.service.sys.ISysUserService;

/**
* @ClassName: SysUserController
* @Description: 
* @author linyan
* @date 2017年7月10日 上午9:47:33
*
*/
@SuppressWarnings({ "unused" })
@Controller
public class SysUserController {

	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping(value = "system/gotoSysUser")
	public String gotoSysUser(HttpServletRequest request,HttpServletResponse response){
		return "sys/sysUser";
	}
	
	@RequestMapping(value = "system/ajaxTableSysUser", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object ajaxTableSysUser(String a,HttpServletRequest request,HttpServletResponse response,Model model){
		String draw = ServletRequestUtils.getStringParameter(request,"draw",null);
		String orderDir = ServletRequestUtils.getStringParameter(request,"order[0][dir]",null);
		Integer start = ServletRequestUtils.getIntParameter(request, "start",0);
		Integer length = ServletRequestUtils.getIntParameter(request, "length",0);
		Integer order = ServletRequestUtils.getIntParameter(request, "order[0][column]",0);
		LyPage<SysUser> page = new LyPage<SysUser>();
		page.setFirst(start);
		page.setEnd(start+length-1);
		page = iSysUserService.selectPageSysUser(page);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("draw", draw);
		result.put("recordsFiltered", page.getTotal());
		result.put("recordsTotal", page.getTotal());
		List<List<Object>> listDate = new ArrayList<List<Object>>(); 
		for (SysUser sysUser : page.getData()) {
			List<Object> row = new ArrayList<Object>();
			row.add(sysUser.getId());
			row.add(sysUser.getUserName());
			row.add(sysUser.getUserId());
			row.add("<a href=\"javascript:;\" class=\"btn btn-sm resetpassbtn\" data-id=\""+sysUser.getId()+"\"><i class=\"fa fa-refresh\"></i>重置密码</a>"+
					"<a href=\"javascript:;\" class=\"btn btn-sm eidtrolebtn\" data-id=\""+sysUser.getId()+"\"><i class=\"fa fa-edit\"></i>修改角色</a>"+
					"<a href=\"javascript:;\" class=\"btn btn-sm delesysuserbtn\" data-id=\""+sysUser.getId()+"\"><i class=\"fa fa-trash\"></i>删除</a>");
			listDate.add(row);
		}
		result.put("data", listDate);
		return result;
	}
	
	@RequestMapping(value = "system/addSysUserRole", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object addSysUserRole(@RequestParam(value = "roleIds[]") String[] roleIds,String sysuserid){
		Map<String, Object> map = new HashMap<String, Object>();
		map = iSysUserService.updateSysUserRole(roleIds,sysuserid);
		return map;
	}
	
	@RequestMapping(value = "system/resetpass" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object resetpass(Integer id){
		Map<String, Object> map = new  HashMap<String, Object>();
		map=iSysUserService.resetPass(id);
		return map;
	}
	
	@RequestMapping(value = "system/deletesysuser" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object deletesysuser(Integer id){
		Map<String, Object> map = new  HashMap<String, Object>();
		try {
			map = iSysUserService.deleteSysUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes", "出错了");
		}
		return map;
	}
	
}
