package com.ly.controller.sys;

import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @ClassName: UserInfoController
* @Description: 
* @author linyan
* @date 2017年7月14日 下午4:48:20
*
*/
@Controller
public class UserInfoController {

	@RequestMapping(value = "goUserInfo")
	public String goUserInfo(){
		return "userInfo/userList";
	}
	
	@RequestMapping(value = "ceshiObject")
	@ResponseBody
	public Object ceshiObject(@RequestBody String g ,String info,HttpServletRequest request,HttpServletResponse response){
		Enumeration<String> e = request.getAttributeNames();
		while (e.hasMoreElements()) {
			String string = (String) e.nextElement();
			Object gg = request.getAttribute(string);
			System.out.println(string+"<<<<>>>>>>>>>>>>>"+gg);
		}
		Enumeration<String>  wEnumeration= request.getHeaderNames();
		while (wEnumeration.hasMoreElements()) {
	        String key = (String) wEnumeration.nextElement();
	        String value = request.getHeader(key);
	        System.out.println(key+"======="+value);
	    }
		System.out.println(g);
		System.out.println("============");
		Map<String, String[]> map = request.getParameterMap();
		
		Set<Map.Entry<String, String[]>> aMaps = map.entrySet();
		for (Entry<String, String[]> entry : aMaps) {
			String af =  entry.getKey();
			String ag = request.getParameter(af);
			System.out.println(af+"<---===--->"+ag);
		}
		System.out.println("----------------");
//		try {
//			InputStreamReader aInputStreamReader = new InputStreamReader(request.getInputStream());
//			StringBufferInputStream nBufferInputStream = new st
//			byte[] b = new byte[request.getContentLength()];
//			request.getInputStream().read(b);
//			String gagggString = new String(b);
//			System.out.println(gagggString+"<<<<");
//			ServletInputStream ris = request.getInputStream();  
			
//			BufferedReader br = request.getReader();
//			String str, wholeStr = "";
//			while((str = br.readLine()) != null){
//			wholeStr += str;
//			}
//			System.out.println(wholeStr+">>>>>");

//			int len = request.getContentLength();
//			ServletInputStream iii = request.getInputStream();
//			byte[] buffer = new byte[len];
//			iii.read(buffer, 0, len);
//			String pwim = new String(buffer);
//			System.out.println(pwim+"<<<<");
			
//		} catch (IOException e1) {
//			
//			e1.printStackTrace();
//		}
		
		return "5";
	}
	
}
