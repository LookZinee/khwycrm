package com.khwy.pojo;

public class UserForm {
	
	private String username;
	private String password;
	private String code;
	private boolean online;
	
	
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	public UserForm(String username, String password, String code, boolean online) {
		super();
		this.username = username;
		this.password = password;
		this.code = code;
		this.online = online;
	}

	public UserForm() {
		// TODO Auto-generated constructor stub
	}

}
