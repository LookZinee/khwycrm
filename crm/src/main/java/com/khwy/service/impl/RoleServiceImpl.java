package com.khwy.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khwy.mapper.RoleMapper;
import com.khwy.pojo.Role;
import com.khwy.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

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

	
	
}
