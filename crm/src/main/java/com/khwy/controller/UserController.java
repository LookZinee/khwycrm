package com.khwy.controller;


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
	public String login(String name,String pwd){
		System.out.println("username:====="+name);
		System.out.println("pwd:==========="+pwd);
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
			token.setRememberMe(true);
			subject.login(token);
			
//			if(subject.isAuthenticated()){
//				return "redirect:/index";
//			}
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
