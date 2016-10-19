package com.khwy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.khwy.model.RoleModel;
import com.khwy.pojo.Role;

public interface RoleMapper {

	Role findById(int roleid);

	List<Role> list();

	int add(Role role);

	int edit(@Param("role") RoleModel role,@Param("parameter") Map<String, Object> parameter);

	int del(Integer roleId);

	Role findByRoleId(Integer roleId);

}
