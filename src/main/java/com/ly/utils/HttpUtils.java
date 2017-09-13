package com.ly.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
* @ClassName: HttpUtils
* @Description: 
* @author linyan
* @date 2017年7月18日 下午4:24:31
*
*/
public class HttpUtils {

	public static Map<String, Object> post(String url,String content){
		System.out.println("url:>"+url);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			URL uri = new URL(url);  
			URLConnection rulConnection = uri.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setUseCaches(false); 
			httpUrlConnection.setRequestMethod("POST");
			DataOutputStream  dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());
//			dataOutputStream.write("".getBytes("utf-8"));
			dataOutputStream.flush();
			dataOutputStream.close();
			StringBuffer stringBuffer = new StringBuffer();
			InputStream inputStream = httpUrlConnection.getInputStream();
			BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			int code = httpUrlConnection.getResponseCode(); 
            if (HttpsURLConnection.HTTP_OK == code){
            	String temp = bufferedReader.readLine(); 
                /*连接成一个字符串*/ 
                while (temp != null) { 
                	stringBuffer.append(temp);
                    temp = bufferedReader.readLine(); 
 	            }
                map.put("code",code);
                map.put("mes", stringBuffer);
            }else {
            	map.put("code",code);
                map.put("mes", httpUrlConnection.getResponseMessage());
			}
		} catch (Exception e) {
			map.put("code", 1);
			map.put("mes", "http请求 出错了 ");
			e.printStackTrace();
		}
		return map;
	}
	
	
	public static void post(String ip,Integer sort){
		try {
			URL url = new URL("http://api.img_ap.dwnews.com/enterprise/index.php/Home/Index/usageCounter");   
			Proxy proxys = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, sort));
//			URLConnection rulConnection = url.openConnection();  
			URLConnection rulConnection = url.openConnection(proxys);  
			        // 此处的urlConnection对象实际上是根据URL的   
			          // 请求协议(此处是http)生成的URLConnection类   
			          // 的子类HttpURLConnection,故此处最好将其转化   
			          // 为HttpURLConnection类型的对象,以便用到   
			          // HttpURLConnection更多的API.如下:   
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			
			// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在   
			 // http正文内，因此需要设为true, 默认情况下是false;   
			 httpUrlConnection.setDoOutput(true);   
			  
			 // 设置是否从httpUrlConnection读入，默认情况下是true;   
			 httpUrlConnection.setDoInput(true);   
			  
			 // Post 请求不能使用缓存   
			 httpUrlConnection.setUseCaches(false);   
			  
			 // 设定传送的内容类型是可序列化的java对象   
			 // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)   
//			 httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			  
			 // 设定请求的方法为"POST"，默认是GET   
//			 httpUrlConnection.setRequestMethod("GET");   
			 httpUrlConnection.setRequestMethod("POST");   
			  
			 // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，   
			 DataOutputStream  dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());
	           dataOutputStream.write("".getBytes("utf-8"));
	           dataOutputStream.flush();
	           dataOutputStream.close();
	           StringBuffer stringBuffer = new StringBuffer();
	   		InputStream inputStream = httpUrlConnection.getInputStream();
	               BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	               int code = httpUrlConnection.getResponseCode(); 
	               System.err.println(code);
	               if (HttpsURLConnection.HTTP_OK == code){
	               	String temp = bufferedReader.readLine(); 
	                   /*连接成一个字符串*/ 
	                   while (temp != null) { 
	                   	stringBuffer.append(temp);
	                       temp = bufferedReader.readLine(); 
	    	            }
	               }
	               System.out.println(stringBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void get(){
		try {
			URL url = new URL("http://general.dwnews.net/index.php?r=api/GetUserApp&uid=497");   
			Proxy proxys = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.23.215.251", 80));
			URLConnection rulConnection = url.openConnection(proxys);  
			        // 此处的urlConnection对象实际上是根据URL的   
			          // 请求协议(此处是http)生成的URLConnection类   
			          // 的子类HttpURLConnection,故此处最好将其转化   
			          // 为HttpURLConnection类型的对象,以便用到   
			          // HttpURLConnection更多的API.如下:   
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			
			// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在   
			 // http正文内，因此需要设为true, 默认情况下是false;   
			 httpUrlConnection.setDoOutput(true);   
			  
			 // 设置是否从httpUrlConnection读入，默认情况下是true;   
			 httpUrlConnection.setDoInput(true);   
			  
			 // Post 请求不能使用缓存   
			 httpUrlConnection.setUseCaches(false);   
			  
			 // 设定传送的内容类型是可序列化的java对象   
			 // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)   
//			 httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			  
			 // 设定请求的方法为"POST"，默认是GET   
			 httpUrlConnection.setRequestMethod("GET");   
			  
			 // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，   
//			 DataOutputStream  dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream());
//	           dataOutputStream.write("data={\"data\":[\"美食\",\"包装\"]}".getBytes("utf-8"));
//	           dataOutputStream.flush();
//	           dataOutputStream.close();
	           StringBuffer stringBuffer = new StringBuffer();
	   			InputStream inputStream = httpUrlConnection.getInputStream();
	               BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	               int code = httpUrlConnection.getResponseCode(); 
	               System.err.println(code);
	               if (HttpsURLConnection.HTTP_OK == code){
	               	String temp = bufferedReader.readLine(); 
	                   /*连接成一个字符串*/ 
	                   while (temp != null) { 
	                   	stringBuffer.append(temp);
	                       temp = bufferedReader.readLine(); 
	    	            }
	               }
	               System.out.println(stringBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		get();
	}
}
