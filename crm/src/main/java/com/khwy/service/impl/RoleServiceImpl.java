package com.khwy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khwy.mapper.OrgMapper;
import com.khwy.mapper.RoleMapper;
import com.khwy.mapper.UserMapper;
import com.khwy.pojo.Role;
import com.khwy.pojo.User;
import com.khwy.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private OrgMapper orgMapper;
	@Autowired
	private UserMapper userMapper;
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public Role findById(int roleid) {
		return roleMapper.findById(roleid);
	}

	@Override
	public List<Role> list() {
		List<Role> list = roleMapper.list();
		System.out.println("list de 长度为："+list.size());
		
		for (int i = 0;i<list.size();i++) {
			list.get(i).setOperName(userMapper.findByUserId(list.get(i).getOperId()).getUsername());
			list.get(i).setOrgName(orgMapper.findById(list.get(i).getOperId()).getFullName());
		}
		return list;
	}

	public OrgMapper getOrgMapper() {
		return orgMapper;
	}

	public void setOrgMapper(OrgMapper orgMapper) {
		this.orgMapper = orgMapper;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public boolean add(Role role) {
		System.out.println("service层   role 的 之");
		System.out.println(role);
		Subject subject = SecurityUtils.getSubject();
	
		Session session = subject.getSession(true);
		User user = (User) session.getAttribute("currentuser");
		role.setCreateTime(new Date());
		role.setOperId(user.getUserid());
		System.out.println("添加数据库之前role的值为"+role);
		int num = roleMapper.add(role);
		if(num > 0){
			System.out.println("添加role成功");
			return true;
		}
		System.out.println("添加失败");
		return false;
	}

	
	
}
