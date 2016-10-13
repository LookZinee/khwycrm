package cn.sxt.mapper;



import java.util.List;

import cn.sxt.vo.User;

public interface UserMapper {
	public User login(String name,String pwd);

	public boolean add(User user);

	public List<User> listByPage(int startNum, int pageSize);

	
}
