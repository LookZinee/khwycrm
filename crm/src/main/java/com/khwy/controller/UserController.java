package com.khwy.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khwy.pojo.UserForm;
import com.khwy.util.MyResult;

@RequestMapping("/user")
@Controller
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
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
	@RequestMapping(value="/login",produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(UserForm user,boolean online,HttpSession session,HttpServletResponse resp) throws IOException{
		//验证 验证码是否正确
		if(!checkCode(user.getCode(), session)){
			return MyResult.codeError().getMessage();
		}
		//判断账号密码 是否正确
		//
		if(user.getUsername() == null ||user.getPassword() == null){
			return MyResult.userNull().getMessage();
		}
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			Subject subject = SecurityUtils.getSubject();
			if( online ==true){
				System.out.println("记住我");
				token.setRememberMe(true);
			}
			subject.login(token);
		} catch (AuthenticationException e) {
			if( e instanceof UnknownAccountException){
				System.out.println(user.getUsername()+":用户名输入错误");
				return MyResult.userFailed().getMessage();
			}
			if(e instanceof IncorrectCredentialsException){
				System.out.println(user.getPassword() +":用户名输入错误");
				return MyResult.userFailed().getMessage();
			}
		}
		return MyResult.success().getMessage();
		
	}
	//判断验证码是否正确
	private boolean checkCode(String code,HttpSession session){
		if(code != null && code.length() > 0){
			String randomNum = (String) session.getAttribute("code");
			if(randomNum.equalsIgnoreCase(code)){
				return true;
			}
		}
		return false;
	}
}
