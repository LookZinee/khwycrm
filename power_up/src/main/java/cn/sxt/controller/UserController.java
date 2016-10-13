package cn.sxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import cn.sxt.service.UserService;
import cn.sxt.vo.PageUtil;
import cn.sxt.vo.User;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	PageUtil pageUtil = new PageUtil();
	@RequestMapping("/login")
	public String login(String name,String pwd, ModelMap map) {
		System.out.println("进入到此方法");
		System.out.println(name+ "======" + pwd);

		map.put("name", name);
		map.put("pwd", pwd);
		User u= userService.login(name,pwd);

		
		if (u != null) {
			System.out.println("user 不为空");
			return list(2, map);
		}
		System.out.println("user 为空");
		return "login";
	}
	@RequestMapping("/register")
	public String register(User user,ModelMap modelMap){
		boolean flag = userService.add(user);
		
		if(flag){
			modelMap.addAttribute("username", user.getName());
			return "login";
		}
		return "error";
	}
	@RequestMapping("/toRegister")
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping("/list")
	public String list(int num,ModelMap modelMap){
		pageUtil.setPageSize(num);
		List<User> list = userService.listByPage((pageUtil.getCurrentNum()-1)*pageUtil.getPageSize(),pageUtil.getPageSize());
		modelMap.addAttribute("userList", list);
		return "index";
	}
	@RequestMapping("/find")
	public void find(int pageSize,int currentPage,HttpServletResponse resp){
		System.out.println("进入到find方法之中");
		System.out.println("num=========="+pageSize);
		if(currentPage != 0){
			pageUtil.setCurrentNum(currentPage);
		}
		pageUtil.setPageSize(pageSize);
		List<User> list = userService.listByPage((pageUtil.getCurrentNum()-1)*pageUtil.getPageSize(),pageUtil.getPageSize());
		Gson gson = new Gson();
		String data = gson.toJson(list);
		try {
			resp.getWriter().write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
