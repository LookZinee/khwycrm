package com.khwy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khwy.pojo.Org;
import com.khwy.pojo.User;
import com.khwy.service.OrgServcie;
import com.khwy.service.UserService;
import com.khwy.util.MyResult;

@RequestMapping("/sys/org")
@Controller
public class OrgSysController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private OrgServcie orgService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{page}")
	public String sysCon(@PathVariable String page){
		return "/sys/org/org-"+page;
	}
	
	@RequestMapping("/list")
	public String list(ModelMap modelMap){
		List<Org> list = orgService.list();
		System.out.println("List 的长度："+list.size());
		modelMap.addAttribute("list", list);
		return sysCon("list");
	}
	@RequestMapping("/toadd")
	public String add(Org org,HttpSession session,ModelMap modelMap){
		System.out.println(org);
		Subject subject = SecurityUtils.getSubject();
		String username = (String)subject.getPrincipal();
		System.out.println("OrgSysController.add(username)========"+username);
		User user = userService.findById(username);
		System.out.println(user);
		org.setOperUserId(user.getUserid());
		System.out.println("OrgSysController.add(ort.operuserid=)======="+org.getOperUserId());
		boolean flag = orgService.add(org);
		if(flag){
			return list(modelMap);
		}
		return "redirect:/error";
	}
	
	@RequestMapping(value="/del",produces="application/json;charset=utf-8")
	@ResponseBody
	public String del(Org org){
		System.out.println("OrgSysController.del()===进入到此方法");
		boolean flag = orgService.del(org.getOrgId());
		if(flag){
			return MyResult.success().getMessage();
		}
		return MyResult.error().getMessage();
	}
	@RequestMapping("/toEdit")
	public String toEdit(Integer orgId,ModelMap mdoelMap){
		System.out.println("OrgSysController.toEdit(orgid)=="+orgId);
		Org org = orgService.findById(orgId);
		mdoelMap.addAttribute("org", org);
		return "sys/org/org-edit";
	}
	@RequestMapping("/edit")
	public String edit(Org org,ModelMap modelMap){
		boolean flag = orgService.edit(org);
		if(flag){
			return list(modelMap);
		}
		return MyResult.error().getMessage();
	}
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		OrgSysController.logger = logger;
	}

	public OrgServcie getOrgService() {
		return orgService;
	}

	public void setOrgService(OrgServcie orgService) {
		this.orgService = orgService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
}
