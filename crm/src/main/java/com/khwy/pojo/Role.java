package com.khwy.pojo;

import java.io.Serializable;

public class Role implements Serializable{
	private static final long serialVersionUID = 6976594433373490923L;
	
	private int roleid;
	private String rolename;
	private String perids;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getPerids() {
		return perids;
	}
	public void setPerids(String perids) {
		this.perids = perids;
	}
	public Role(int roleid, String rolename, String perids) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.perids = perids;
	}
	public Role() {
	}
	
}
