package com.khwy.service.impl;

import org.springframework.stereotype.Service;

import com.khwy.mapper.RoleMapper;
import com.khwy.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	private RoleMapper roleMapper;

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
}
