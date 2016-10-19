package com.khwy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.khwy.model.RoleModel;
import com.khwy.pojo.Org;
import com.khwy.pojo.Per;
import com.khwy.pojo.Role;
import com.khwy.service.OrgServcie;
import com.khwy.service.PerServcie;
import com.khwy.service.RoleService;
import com.khwy.util.MyResult;

@Controller()
@RequestMapping("/sys/role")
public class RoleSysController {
	private static  Logger logger =LoggerFactory.getLogger(RoleSysController.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrgServcie orgServcie;
	@Autowired
	private PerServcie perService;
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
	@RequestMapping("/edit")
	public String edit(RoleModel role,ModelMap modelMap){
		System.out.println("RoleSysController.edit(role)="+role);
		Map<String, Object> parameter = new HashMap<>();
		boolean flag = roleService.edit(role,parameter);
		return list(modelMap);
	}
	@RequestMapping(value="/del",produces="application/json;charset=utf-8")
	@ResponseBody
	public String del(Integer roleId){
		System.out.println("要删除的role的id是：---------"+roleId);
		MyResult delt = roleService.del(roleId);
		System.out.println("del的message："+delt.getMessage());
		return delt.getMessage();
	}
	@RequestMapping("/auth")
	public String auth(Integer roleId,ModelMap modelMap){
		System.out.println("要进行授权的角色Id 是：------"+roleId);
		Role role = roleService.findByRoleId(roleId);
		modelMap.addAttribute("role", role);
		List<Per> perList = perService.list();
		modelMap.addAttribute("perList", perList);
		return pageCon("authc");
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
	public PerServcie getPerService() {
		return perService;
	}
	public void setPerService(PerServcie perService) {
		this.perService = perService;
	}

}
