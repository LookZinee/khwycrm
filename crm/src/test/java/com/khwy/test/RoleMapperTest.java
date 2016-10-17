package com.khwy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khwy.mapper.RoleMapper;
import com.khwy.pojo.Role;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-mvc.xml",
		"classpath:spring/applicationContext-shiro.xml","classpath:spring/applicationContext.xml"})
public class RoleMapperTest {
	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	public void listMapper(){
		List<Role> list = roleMapper.list();
		for (Role role : list) {
			System.out.println(role);
		}
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
}
