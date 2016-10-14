package com.khwy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khwy.mapper.UserMapper;
import com.khwy.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-mvc.xml",
		"classpath:spring/applicationContext-shiro.xml","classpath:spring/applicationContext.xml"})
public class MapperTest {
	@Autowired
	UserMapper userMapper;
	@Test
	public void testMapper(){
		User user = userMapper.findById("zinee");
		if(user!= null){
			System.out.println(user.getUsername());
		}
		System.out.println("ok");
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
}
