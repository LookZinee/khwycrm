package cn.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.mapper.UserMapper;
import cn.sxt.service.UserService;
import cn.sxt.vo.PageUtil;
import cn.sxt.vo.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	public User login(String name,String pwd) {
		return userMapper.login(name,pwd);
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	public boolean add(User user) {
		return userMapper.add(user);
	}
	public List<User> listByPage(int startNum,int pageSize) {
		return userMapper.listByPage(startNum,pageSize);
	}
	

}
