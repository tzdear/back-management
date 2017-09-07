package com.ly.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.po.SysTree;
import com.ly.service.sys.ISysTreeService;

/**
* @ClassName: SysTreeController
* @Description: 
* @author linyan
* @date 2017年7月16日 下午7:09:29
*
*/
@Controller
public class SysTreeController {

	@Autowired
	private ISysTreeService sysTreeService;
	
	@RequestMapping(value = "tree")
	public String goToTree(HttpServletRequest request,HttpServletResponse response){
		return "sys/tree";
	}
	
	@RequestMapping(value = "giveRoleTree" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object giveRoleTree(Integer id){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = sysTreeService.giveRoleTree(id);
		return list;
	}
	
	@RequestMapping(value = "selectAllTree" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object selectAllTree(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = sysTreeService.selectAllTree();
			map.put("code",0);
			map.put("mes", "");
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes","哎呀，怎么出错了呢。");
		}
		return map;
	}
	
	
	@RequestMapping(value = "selectTreeNo",produces ="application/json;charset=utf-8")
	@ResponseBody
	public Object selectTreeNo(Integer treeNo){
		List<SysTree> sysTrees = sysTreeService.selectTreeByTreeNo(treeNo);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (SysTree sysTree : sysTrees) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id",sysTree.getId());
			map.put("text",sysTree.getChName());
			list.add(map);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		map.put("mes", "");
		return map;
	}
	
	@RequestMapping(value = "selectOneById",produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object selectOneById(Integer id){
		SysTree sysTree = sysTreeService.selectOneById(id);
		return sysTree;
	}
	
	@RequestMapping(value = "updateTree" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object updateTree(String treeIdOrder){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			sysTreeService.updateTree(treeIdOrder);
			map.put("code",0);
			map.put("mes", "");
		} catch (Exception e) {
			map.put("code", 1);
			map.put("mes", "抱歉，出错了。");
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping(value = "addTree" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object addTree(SysTree sysTree){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			sysTreeService.addOrUpdateTree(sysTree);
			map.put("code", 0);
			map.put("mes","");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", 1);
			map.put("mes", "保存过程中发生了不可预计的错误。");
		}
		return map;
	}
	
	
	@RequestMapping(value = "deleteTree" ,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object deleteTree(Integer id ){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = sysTreeService.deleteTree(id);
			map.put("code", 0);
			map.put("mes", "");
		} catch (Exception e) {
			map.put("code",1);
			map.put("mes", "啊哦，出错了。");
			e.printStackTrace();
		}
		return map;
	}
	
}
