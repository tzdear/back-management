package com.ly.controller.test;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
* @ClassName: TestFile
* @Description: 
* @author linyan
* @date 2017年8月9日 上午11:08:56
*
*/
@Controller
public class TestFileController {

	
	
	@RequestMapping(value ="testFile")
	public String testFile(){
		return "test/TestFile";
	}
	
	@RequestMapping(value = "fileupdate")
	@ResponseBody
	public Object fileupdate(HttpServletRequest request ,HttpServletResponse response ,String iop){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;           
		Iterator<String> names = multipartRequest.getFileNames();

		while (names.hasNext()) {
            String name = (String) names.next();
            MultipartFile multipartFile = multipartRequest.getFile(name);
            System.out.println(multipartFile.getOriginalFilename());
		}
		return "0";
	}
//	@RequestMapping(value = "fileupdate")
//	@ResponseBody
//	public Object fileupdate(HttpServletRequest request,@RequestParam("file[]") MultipartFile file ,HttpServletResponse response ,String iop){
//		String fName=file.getName();
//		String gglString = file.getOriginalFilename();
//		System.out.println(gglString);
//		String type = file.getContentType();
//		System.out.println(type);	
//		System.out.println(fName+">>>>>>>>>>>>>>>>");
//		System.out.println(iop);
//		
//		return "0";
//	}
}
