package com.khwy.service;

import java.util.List;
import java.util.Set;

import com.khwy.pojo.Role;

public interface RoleService {

	Role findById(int i);

	List<Role> list();

	boolean add(Role role);

}
