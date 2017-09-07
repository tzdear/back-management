package com.ly.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
* @ClassName: HandshakeInterceptor
* @Description: 
* @author linyan
* @date 2017年8月31日 下午4:38:47
*
*/
//@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
		System.out.println("afterHandshake");
//		HttpHeaders ag = request.getHeaders();
//		Set<Entry<String, List<String>>> set = ag.entrySet();
//		for (Entry<String, List<String>> entry : set) {
//			String key = entry.getKey();
//			List<String> list = entry.getValue();
//			String value = null;
//			for (String string : list) {
//				value +=string;
//			}
//			System.out.println(key+"======================================="+value);
//		}
		try {
			OutputStream os = response.getBody();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();  
			os.write(baos.toByteArray());  
			String str = baos.toString(); 
			System.out.println(str);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Map<String, Object> arg3) throws Exception {
		System.out.println("beforeHandshake");
//		HttpHeaders ag = arg0.getHeaders();
//		Set<Entry<String, List<String>>> set = ag.entrySet();
//		for (Entry<String, List<String>> entry : set) {
//			String key = entry.getKey();
//			List<String> list = entry.getValue();
//			String value = "";
//			for (String string : list) {
//				value +=string;
//			}
//			System.out.println(key+"======================================="+value);
//		}
		try {
			OutputStream os = arg1.getBody();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();  
			os.write(baos.toByteArray());  
			String str = baos.toString(); 
			System.out.println(str);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return super.beforeHandshake(arg0, arg1, arg2, arg3);
	}

	
	
}
