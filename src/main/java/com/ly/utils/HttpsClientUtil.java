package com.ly.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;  


public class HttpsClientUtil {
	
	
	private static X509TrustManager x509TrustManager = new X509TrustManager() {
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
		
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}
	};
	
	/**
	 * @Title: httpsPost
	 * @author: linyan
	 * @Description: https  的post 请求方式 
	 * @param url   
	 * @param per  String 类型的参数
	 * @param proxy  是否需要代理  true 是
	 * @return
	 */
	public static String httpsPost(String url,String body,Map<String, String> headers , boolean proxy) {
		try {
			HttpsURLConnection httpsURLConnection = getHttpsUrlConnection(url,headers, proxy);
            httpsURLConnection.setRequestMethod("POST");
           httpsURLConnection.setReadTimeout(30000);
           httpsURLConnection.setDoInput(true);
           httpsURLConnection.setDoOutput(true);
           DataOutputStream  dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
           dataOutputStream.write(body.getBytes("utf-8"));
           dataOutputStream.flush();
           dataOutputStream.close();
           return getResultToString(httpsURLConnection);
       } catch (Exception e) {
           e.printStackTrace();
       }
		return "";
	}
	/**
	 * @Title: httpsPost
	 * @author: linyan
	 * @Description: https  的post 请求方式 
	 * @param url
	 * @param map  Map 类型的参数 
	 * @param proxy  是否需要代理  true 是
	 * @return
	 */
	 public static String httpsPost(String url ,Map<String, Object> body,Map<String,String> headers,boolean proxy) {
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			String per = objectMapper.writeValueAsString(body);
			return httpsPost(url,per,headers,proxy);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		 return "";
    }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @param proxy
	  * @return
	  */
	 public static String httpsPost(String url,Map<String, Object> body,boolean proxy) {
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			String per = objectMapper.writeValueAsString(body);
			return httpsPost(url,per,new HashMap<String, String>(),proxy);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		 return "";
    }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @return
	  */
	 public static String httpsPost(String url,Map<String, Object> body) {
		return httpsPost(url,body,false);
    }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @param headers
	  * @return
	  */
	 public static String httpsPost(String url ,Map<String, Object> body,Map<String,Object> headers) {
		 return  httpsPost(url,body,new HashMap<String, String>(),false);
	 }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @param headers
	  * @return
	  */
	 public static String httpsPost(String url ,String body,Map<String,Object> headers) {
		 return  httpsPost(url,body,new HashMap<String, String>(),false);
	 }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @param proxy
	  * @return
	  */
	 public static String httpsPost(String url,String body , boolean proxy) {
		return  httpsPost(url,body,new HashMap<String, String>(),proxy);
	 }
	 /**
	  * @Title: httpsPost
	  * @author: linyan
	  * @Description: 
	  * @param url
	  * @param body
	  * @return
	  */
	 public static String httpsPost(String url,String body) {
		return  httpsPost(url,body,false);
	 }
	 
	 
	/**
	 * @Title: httpsGet
	 * @author: linyan
	 * @Description: https 的 get 请求
	 * @param url
	 * @param proxy 是否需要代理  true 是
	 * @return
	 */
	public static String httpsGet(String url,Map<String, String> headers,boolean proxy) {
		 try {
            HttpsURLConnection httpsURLConnection = getHttpsUrlConnection(url,headers, proxy);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setDoInput(true);
            return getResultToString(httpsURLConnection);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * @Title: getHttpsUrlConnection
	 * @author: linyan
	 * @Description:  根据 url  和   proxy 得到  HttpsURLConnection
	 * @param url 
	 * @param proxy  是否需要代理  true 是
	 * @return
	 */
	public static HttpsURLConnection getHttpsUrlConnection(String url ,Map<String, String> headers, boolean proxy){
		HttpsURLConnection httpsURLConnection = null;
		try {
			SSLContext context = SSLContext.getInstance("TLS");
	        context.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
	        if (proxy) {
	           	Proxy proxys = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.23.215.251", 80));
	           	httpsURLConnection = (HttpsURLConnection)new URL(url).openConnection(proxys);
			}else {
				httpsURLConnection = (HttpsURLConnection)new URL(url).openConnection();
			}
	        httpsURLConnection.setSSLSocketFactory(context.getSocketFactory());
	        for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
			}
//	        httpsURLConnection.setRequestProperty("Content-Type","application/json;charset=utf-8"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpsURLConnection;
	}
	
	/**
	 * @Title: getResultToString
	 * @author: linyan
	 * @Description: 根据  httpsUrlConnerction 得到 String 类型的 返回值
	 * @param httpsURLConnection
	 * @return
	 */
	public static String getResultToString(HttpsURLConnection httpsURLConnection){
		StringBuffer stringBuffer = new StringBuffer();
		try {
			InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int code = httpsURLConnection.getResponseCode(); 
            if (HttpsURLConnection.HTTP_OK == code){
            	String temp = bufferedReader.readLine(); 
                /*连接成一个字符串*/ 
                while (temp != null) { 
                	stringBuffer.append(temp);
                    temp = bufferedReader.readLine(); 
 	            }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	/**
	 * @Title: httpsGet
	 * @author: linyan
	 * @Description: 
	 * @param url
	 * @return
	 */
	public static String httpsGet(String url){
		return httpsGet(url,new HashMap<String, String>());
	}
	/**
	 * @Title: httpsGet
	 * @author: linyan
	 * @Description: 
	 * @param url
	 * @param headers
	 * @return
	 */
	public static String httpsGet(String url ,Map<String, String> headers){
		return httpsGet(url,headers, false);
	}
	
	/**
	 * @Title: httpsPushPost
	 * @author: linyan
	 * @Description: 推送
	 * @param url
	 * @param body
	 * @param proxy
	 * @return
	 */
	public static String httpsPushPost(String url,Map<String, Object> body , boolean proxy) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "key=AAAALcSMN3Q:APA91bHoolfibYVa3g2MotA_8zfN3jBq27F4QBRFvlyDa23tFgZWJ29UPGrqKImoEelmXZ31Yij_S51E0ZyX3qRWJit3VHURQmE896aXXvEUgsd99yYfB545SLjJP05VcWaUEjxuY-iF");
		return httpsPost(url, body , headers,proxy);
	}
	/**
	 * @Title: httpsPushPost
	 * @author: linyan
	 * @Description: 推送
	 * @param url
	 * @param body
	 * @return
	 */
	public static String httpsPushPost(String url,Map<String, Object> body ) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "key=AAAALcSMN3Q:APA91bHoolfibYVa3g2MotA_8zfN3jBq27F4QBRFvlyDa23tFgZWJ29UPGrqKImoEelmXZ31Yij_S51E0ZyX3qRWJit3VHURQmE896aXXvEUgsd99yYfB545SLjJP05VcWaUEjxuY-iF");
		return httpsPost(url, body , headers,false);
	}
	
	public static void main(String[] args) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		headers.put("Authorization", "key=AAAALcSMN3Q:APA91bHoolfibYVa3g2MotA_8zfN3jBq27F4QBRFvlyDa23tFgZWJ29UPGrqKImoEelmXZ31Yij_S51E0ZyX3qRWJit3VHURQmE896aXXvEUgsd99yYfB545SLjJP05VcWaUEjxuY-iF");
		Map<String, Object> notiDate = new HashMap<String, Object>();
		notiDate.put("click_action", "OPEN_DW_NEWS");
		notiDate.put("icon", "myicon");
		notiDate.put("news_type", "features");
		notiDate.put("ikey","a" );
		notiDate.put("url","s" );
		notiDate.put("channel","" );
		notiDate.put("title","杀戮空间福利卡");
		notiDate.put("body","杀戮空间福利卡");
		notiDate.put("author","杀戮空间福利卡");
		notiDate.put("picurl","h");
		notiDate.put("datetime",System.currentTimeMillis());
		Map<String, Object> appDataMap = new HashMap<String, Object>();
		appDataMap.put("to", "/topics/dw_news");
		appDataMap.put("priority", "high");
		appDataMap.put("notification", notiDate);
		appDataMap.put("data", notiDate);
		String al = "{\r\n    \"notification\": {\r\n        \"picurl\": \"http://pic0.dwnews.net/20170712/d0f06a578a1d200ba4a9836902ef4a20_w.jpg\",\r\n        \"datetime\": 1499933165711,\r\n        \"news_type\": \"features\",\r\n        \"author\": \"asd g\",\r\n        \"ikey\": 50000057,\r\n        \"icon\": \"myicon\",\r\n        \"channel\": \"\",\r\n        \"click_action\": \"OPEN_DW_NEWS\",\r\n        \"title\": \"测试欧拉几个3\",\r\n        \"body\": \"测试欧拉几个2测试欧拉几个2测试欧拉几个2测试欧拉几个2测试欧拉几个2\",\r\n        \"url\": null\r\n    },\r\n    \"data\": {\r\n        \"picurl\": \"http://pic0.dwnews.net/20170712/d0f06a578a1d200ba4a9836902ef4a20_w.jpg\",\r\n        \"datetime\": 1499933165711,\r\n        \"news_type\": \"features\",\r\n        \"author\": \"asd g\",\r\n        \"ikey\": 50000057,\r\n        \"icon\": \"myicon\",\r\n        \"channel\": \"\",\r\n        \"click_action\": \"OPEN_DW_NEWS\",\r\n        \"title\": \"测试欧拉几个3\",\r\n        \"body\": \"测试欧拉几个2测试欧拉几个2测试欧拉几个2测试欧拉几个2测试欧拉几个2\",\r\n        \"url\": null\r\n    },\r\n    \"to\": \"/topics/dw_news\",\r\n    \"priority\": \"high\"\r\n}";
		try {
			al = new ObjectMapper().writeValueAsString(appDataMap);
			System.out.println(new ObjectMapper().writeValueAsString(appDataMap));
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		String hg =  httpsPost("",al , headers,true);
		System.out.println(hg);
	}
	
	
}
