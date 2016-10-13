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

public class UserRealm extends AuthorizingRealm{
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//授权 分配角色
		Set<String> roles = new HashSet<String>();
		roles.add("role1");
		roles.add("boss");
		
		Set<String> permissions = new HashSet<String>();
		permissions.add("createUser");
		permissions.add("updateUser");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//模拟数据库中的信息
		String username= "zinee";
		String pwd = "b303857020cf6351cb85107180a0669c";
		String salt = "zinee";
		
		String name = (String) token.getPrincipal();
		if(!name.equals(username)){
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, pwd, ByteSource.Util.bytes(salt), getName());
		return info;
	}
	
}
