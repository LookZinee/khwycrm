package com.khwy.pojo;

import java.io.Serializable;

public class Per implements Serializable{

	private static final long serialVersionUID = -4855598489409808754L;

	private Integer perId;
	private String perName;
	private String des;
	private Integer parentId;
	public Integer getPerId() {
		return perId;
	}
	public void setPerId(Integer perId) {
		this.perId = perId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Per(Integer perId, String perName, String des, Integer parentId) {
		super();
		this.perId = perId;
		this.perName = perName;
		this.des = des;
		this.parentId = parentId;
	}
	public Per() {
	}
	@Override
	public String toString() {
		return "Per [perId=" + perId + ", perName=" + perName + ", des=" + des + ", parentId=" + parentId + "]";
	}
	
	

}
