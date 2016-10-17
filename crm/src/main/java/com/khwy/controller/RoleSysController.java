package com.khwy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khwy.pojo.Org;
import com.khwy.pojo.Role;
import com.khwy.service.OrgServcie;
import com.khwy.service.RoleService;

@Controller()
@RequestMapping("/sys/role")
public class RoleSysController {
	private static  Logger logger =LoggerFactory.getLogger(RoleSysController.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrgServcie orgServcie;
	@RequestMapping("/{page}")
	public String pageCon(@PathVariable String page){
		return "sys/role/role-"+page;
	}
	@RequestMapping("/list")
	public String list(ModelMap modelMap){
		List<Role> list = roleService.list();
		modelMap.addAttribute("list", list);
		return pageCon("list");
	}
	@RequestMapping("/toadd")
	public String toadd(ModelMap modelMap){
		List<Org> orgList = orgServcie.list();
		modelMap.addAttribute("orgList", orgList);
		return pageCon("add");
	}
	@RequestMapping("/add")
	public String add(Role role,ModelMap modelMap){
		boolean flag = roleService.add(role);
		return list(modelMap);
	}
	@RequestMapping("/toedit")
	public String toedit(Integer roleId,ModelMap modelMap){
		System.out.println("roleid============"+roleId);
		Role role = roleService.findById(roleId);
		System.out.println("RoleSysController.toedit(role)====="+role);
		List<Org> orgList = orgServcie.list();
		modelMap.addAttribute("orgList", orgList);
		modelMap.addAttribute("role", role);
		return pageCon("edit");
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public OrgServcie getOrgServcie() {
		return orgServcie;
	}
	public void setOrgServcie(OrgServcie orgServcie) {
		this.orgServcie = orgServcie;
	}

}
