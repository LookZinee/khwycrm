package com.khwy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khwy.mapper.OrgMapper;
import com.khwy.mapper.UserMapper;
import com.khwy.pojo.Org;
import com.khwy.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-mvc.xml",
		"classpath:spring/applicationContext-shiro.xml","classpath:spring/applicationContext.xml"})
public class MapperTest {
	@Autowired
	UserMapper userMapper;
	@Autowired
	OrgMapper orgMapper;
	@Test
	public void testMapper(){
		User user = userMapper.findById("zinee");
		if(user!= null){
			System.out.println(user.getUsername());
		}
		System.out.println("ok");
	}
	
	@Test
	public void testOrgMapper(){
		List<Org> list = orgMapper.list();
		System.out.println("list 的长度为："+list.size());
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	public OrgMapper getOrgMapper() {
		return orgMapper;
	}
	public void setOrgMapper(OrgMapper orgMapper) {
		this.orgMapper = orgMapper;
	}
	
}
