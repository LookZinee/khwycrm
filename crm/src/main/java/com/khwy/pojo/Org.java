package com.khwy.pojo;
/*
 *  `orgId` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '组织id',
  `orgCode` VARCHAR(50) NOT NULL COMMENT '组织编码',
  `simpleName` VARCHAR(50) NOT NULL COMMENT '组织简称',
  `fullName` VARCHAR(100) NOT NULL COMMENT '组织全称',
  `introduce` VARCHAR(400) NOT NULL COMMENT '部门简介',
  `operUserId` INT(11) NOT NULL COMMENT '操作人',
  `remark` VARCHAR(400) COMMENT '备注信息' 
 */
import java.io.Serializable;

public class Org implements Serializable{
	
	private static final long serialVersionUID = -164037082407369990L;
	
	private Integer orgId; //编号
	private String orgCode; //部门代码
	private String simpleName;//简称
	private String fullName; //全称
	private String introduce;//介绍
	private int operUserId;//操作者的id
	private String remark;//备注
	private User user;//操作者
	
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getOperUserId() {
		return operUserId;
	}
	public void setOperUserId(int operUserId) {
		this.operUserId = operUserId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Org() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgCode=" + orgCode + ", simpleName=" + simpleName + ", fullName=" + fullName
				+ ", introduce=" + introduce + ", remark=" + remark + "]";
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Org(Integer orgId, String orgCode, String simpleName, String fullName, String introduce, int operUserId,
			String remark, User user) {
		super();
		this.orgId = orgId;
		this.orgCode = orgCode;
		this.simpleName = simpleName;
		this.fullName = fullName;
		this.introduce = introduce;
		this.operUserId = operUserId;
		this.remark = remark;
		this.user = user;
	}
	
}
