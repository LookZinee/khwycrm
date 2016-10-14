package com.khwy.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.khwy.pojo.User;
import com.khwy.service.RoleService;
import com.khwy.service.UserService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//授权 分配角色
//		Set<String> roles = new HashSet<String>();
//		roles.add("role1");
//		roles.add("boss");
		System.out.println("授权");
		System.out.println("UserRealm.doGetAuthorizationInfo(principals)=="+(String)principals.getPrimaryPrincipal());
		//Set<String> roles = roleService.findById();
		
		Set<String> permissions = new HashSet<String>();
		permissions.add("createUser");
		permissions.add("updateUser");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		User user = userService.findById((String)token.getPrincipal());
		String username = "";
		String pwd = "";
		String salt = "";
		if(user != null){
			username = user.getUsername();
			pwd = user.getPassword();
			salt = user.getSalt();
			System.out.println("UserRealm.doGetAuthenticationInfo(username):"+username);
			System.out.println("UserRealm.doGetAuthenticationInfo(pwd):"+pwd);
			System.out.println("UserRealm.doGetAuthenticationInfo(salt):"+salt);
		}
		
		String name = (String) token.getPrincipal();
		if(!name.equals(username)){
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, pwd, ByteSource.Util.bytes(salt), getName());
		return info;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
}
