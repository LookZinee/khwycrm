package com.khwy.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	@RequestMapping("/login")
	public String login(String username,String password,String randomNum,String online,HttpSession session){
		
		System.out.println("username:====="+username);
		System.out.println("pwd:==========="+password);
		System.out.println("randomNum====="+randomNum);
		System.out.println("online====="+online);
		String num = (String) session.getAttribute("code");
		System.out.println("code======"+num);
		
		if(!randomNum.equalsIgnoreCase(num)){
			System.out.println("验证码错误！");
			return "redirect:/index";
		}
		
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			if("1".equals(online)){
				token.setRememberMe(true);
			}
			
			subject.login(token);
			
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println("111");
		return "redirect:/index";
//		return "login";
	}
	@RequestMapping("/logout")
	public String logout(){
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
		} catch (Exception e) {
			LoggerFactory.getLogger(this.getClass()).error("退出异常",e);
		}
		return "redirect:/index";
	}
	
}
