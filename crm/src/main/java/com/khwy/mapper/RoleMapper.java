package com.khwy.mapper;

import java.util.List;

import com.khwy.pojo.Role;

public interface RoleMapper {

	Role findById(int roleid);

	List<Role> list();

	int add(Role role);

}
