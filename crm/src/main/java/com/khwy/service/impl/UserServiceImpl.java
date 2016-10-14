package com.khwy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khwy.mapper.UserMapper;
import com.khwy.pojo.User;
import com.khwy.service.UserService;
@Service("userServie")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public User findById(String username) {
		return userMapper.findById(username);
	}

}
