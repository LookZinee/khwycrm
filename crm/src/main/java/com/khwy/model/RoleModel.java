package com.khwy.model;

import java.io.Serializable;
import java.util.Date;

public class RoleModel implements Serializable{
	
	private static final long serialVersionUID = 3498470073671393629L;
	private Integer roleId;
	private String roleName;
	private Integer orgId;
	private Integer operId;
	private String remark;
	private Date createTime;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getOperId() {
		return operId;
	}
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public RoleModel(Integer roleId, String roleName, Integer orgId, Integer operId, String remark) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.orgId = orgId;
		this.operId = operId;
		this.remark = remark;
	}
	public RoleModel() {
	}
	@Override
	public String toString() {
		return "RoleModel [roleId=" + roleId + ", roleName=" + roleName + ", orgId=" + orgId + ", operId=" + operId
				+ ", remark=" + remark + "]";
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
