package com.khwy.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -9038282357081093456L;
	private int userid;
	private String username;
	private String password;
	private String salt;
	private String roleids;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User() {
	}
	public String getRoleids() {
		return roleids;
	}
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	public User(int userid, String username, String password, String salt, String roleids) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.roleids = roleids;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", roleids=" + roleids + "]";
	}

	
}
