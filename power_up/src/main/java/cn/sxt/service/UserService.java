package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.PageUtil;
import cn.sxt.vo.User;

public interface UserService {
	public User login(String name,String pwd);

	public boolean add(User user);

	public List<User> listByPage(int startNum,int pageSize);
}
