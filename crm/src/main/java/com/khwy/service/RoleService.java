package com.khwy.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.khwy.model.RoleModel;
import com.khwy.pojo.Role;
import com.khwy.util.MyResult;

public interface RoleService {

	Role findById(int i);

	List<Role> list();

	boolean add(Role role);

	boolean edit(RoleModel role, Map<String, Object> parameter);

	MyResult del(Integer roleId);
	Role findByRoleId(Integer roleId);

}
