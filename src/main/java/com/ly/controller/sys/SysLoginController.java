package com.ly.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName: SysLoginController
* @Description: 
* @author linyan
* @date 2017年7月12日 下午5:39:56
*
*/
@Controller
@RequestMapping(value="sys")
public class SysLoginController {

	@RequestMapping(value="login")
	public String login(String userName , String userPass , String remenber , HttpServletRequest request,HttpServletResponse response,Model model){
		System.out.println("remenber:" + userName);
		System.out.println("userPass:" + userPass);
		System.out.println("remenber:" + remenber);
//		SecurityUtils.getSubject().login(new UsernamePasswordToken(userName, userPass));
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName, userPass);
		if (remenber != null && !remenber.trim().equals("")) {
			token.setRememberMe(true);
		}
		String url = "index";
		System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		// 获取当前的Subject
		Subject currentUser=SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			System.out.println("对用户[" + userName + "]进行登录验证..验证开始");
			currentUser.login(token);
			url = "redirect:/sys/main";
			System.out.println("对用户[" + userName + "]进行登录验证..验证通过");
		} catch (UnknownAccountException a) {
			System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
			request.setAttribute("mes", "未知账户");
		} catch (IncorrectCredentialsException a) {
			System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
			request.setAttribute("mes", "密码不正确");
		} catch (LockedAccountException a) {
			System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
			request.setAttribute("mes", "账户已锁定");
		} catch (ExcessiveAttemptsException a) {
			System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
			request.setAttribute("mes", "用户名或密码错误次数过多");
		} catch (AuthenticationException a) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			System.out.println("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
			a.printStackTrace();
			request.setAttribute("mes", "用户名或密码不正确");
		} catch (IndexOutOfBoundsException e) {
			request.setAttribute("mes", "密码不正确");
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("mes", "用户名或密码不正确");
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value = "index")
	public String index(String mes,Model model){
		SecurityUtils.getSubject().logout();
		model.addAttribute("mes", mes);
		return "index";
	}
	
	@RequestMapping(value = "logout")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "redirect:index";
	}
	
	@RequestMapping(value="main")
	public String goMain(HttpServletRequest request,HttpServletResponse response){
		return "main";
	}
	
	@RequestMapping(value="goMainBody")
	public String goMainBody(){
		return "mainBody";
	}
	
	@RequestMapping(value ="unauthenticated")
	public String unauthenticated(){
		return "unauthenticated";
	}
	
	@RequestMapping(value = "unauthorized")
	public String unauthorized(){
		return "unauthorized";
	}
	
	@RequestMapping(value = "forezerofore")
	public String forezerofore(){
		return "forezerofore";
	}
	
	@RequestMapping(value ="fivezerozero")
	public String fivezerozero(){
		return "fivezerozero";
	}
}
