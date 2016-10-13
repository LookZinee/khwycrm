package com.khwy.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
			subject.login(token);
//			if(subject.isAuthenticated()){
//				return "redirect:/index";
//			}
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("111");
		return "redirect:/index";
//		return "login";
	}
	
}
