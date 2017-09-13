package com.ly.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Component;

/**
* @ClassName: SendSMS
* @Description: 
* @author linyan
* @date 2017年9月8日 下午5:25:59
*
*/
public class SendSMS {
	
	public static Map<String, Object> sendSms(List<Long> mobiles ,String content){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			StringBuffer sBuffer = new StringBuffer();
			for (Long integer : mobiles) {
				sBuffer.append(integer+",");
			}
			String mobile = sBuffer.substring(0, sBuffer.length()-1);
			String url = "http://web.cr6868.com/asmx/smsservice.aspx";
			StringBuffer stringBuffer = new StringBuffer(url);
			stringBuffer.append("?name=13161983141");
			stringBuffer.append("&pwd=8AA502530DDA5887E270D6CB08DA");
			stringBuffer.append("&content="+content);
			stringBuffer.append("&mobile="+mobile);
			stringBuffer.append("&sign=");
			stringBuffer.append("&type=pt&extno=");
			Map<String, Object> httpMap = HttpUtils.post(url, "");
			Integer code = Integer.valueOf(String.valueOf(httpMap.get("code")));
			if (code==HttpsURLConnection.HTTP_OK) {
				String mesString = String.valueOf(httpMap.get("mes"));
				String[] mess = mesString.split(",");
				String mesCode = mess[0];
				if ("0".equals(mesCode)) {
					map.put("code", 0);
					map.put("mes", mesString);
				}else {
					map.put("code", mesCode);
					map.put("mes", mess[1]);
				}
			}else {
				map.put("code", code);
				map.put("mes", httpMap.get("mes"));	
			}
		} catch (Exception e) {
			map.put("code", 20);
			map.put("mes", "发送短信出错了");
		}
		return map;
	}
	
	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		list.add(13161983141L);
//		Map<String, Object> map = sendSms(list,"【酒频道】领酒中心 验证码：123456，请保管好您的验证码。");
		try {
			Map<String, String> map = smsMt("13161983141", "【酒频道】领酒中心 验证码：123456，请保管好您的验证码。", "");
			System.out.println(map.get("code"));
			System.out.println(map.get("msg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String,String> smsMt(String mobiles,String content,String i) throws IOException {
		String sign="";
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://web.cr6868.com/asmx/smsservice.aspx?");
		// 向StringBuffer追加用户名
		sb.append("name=13161983141");
		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=8AA502530DDA5887E270D6CB08DA");
		// 向StringBuffer追加手机号码
		sb.append("&mobile=");
		sb.append(mobiles);
		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
		//追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");
		//加签名
		sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
		//type为固定值pt  extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		//String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		URL url = new URL(sb.toString());
		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");
		// 发送
		InputStream is =url.openStream();
		//转换返回值
		String returnStr = convertStreamToString(is);
		is.close();
		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
//		System.out.println(returnStr);
		// 返回发送结果
		String[] smsReturn = returnStr.split(",");
		Map<String,String> map = new HashMap<String, String>();
		if (smsReturn[0].equals("0")) {
			String code = smsReturn[0];
			String sendid = smsReturn[1];
			String invalidcount = smsReturn[2];
			String successcount = smsReturn[3];
			String blackcount = smsReturn[4];
			String msg = smsReturn[5];
			map.put("code",code);
			map.put("sendid",sendid);
			map.put("invalidcount",invalidcount);
			map.put("successcount",successcount);
			map.put("blackcount",blackcount);
			map.put("msg",msg);
			return map;
		}else {
			String code = smsReturn[0];
			String msg = smsReturn[1];
			map.put("code",code);
			map.put("msg",msg);
			return map;
		}
	}
	
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
}
