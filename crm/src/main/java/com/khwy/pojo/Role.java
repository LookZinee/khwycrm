package com.khwy.pojo;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	private static final long serialVersionUID = 6976594433373490923L;
	
	private Integer roleId;
	private String roleName;
	private String roleCode;
	private Integer orgId;
	private Date createTime;
	private Integer operId;
	private String remark;
	private String perids;
	
	private String orgName;
	private String operName;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOperId() {
		return operId;
	}
	
	public void setOperId(Integer operId) {
		this.operId = operId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPerids() {
		return perids;
	}
	public void setPerids(String perids) {
		this.perids = perids;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Role() {
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", orgId=" + orgId
				+ ", createTime=" + createTime + ", operId=" + operId + ", remark=" + remark + ", perids=" + perids
				+ ", orgName=" + orgName + ", operName=" + operName + "]";
	}
	public Role(Integer roleId, String roleName, String roleCode, Integer orgId, Date createTime, Integer operId,
			String remark, String perids, String orgName, String operName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.orgId = orgId;
		this.createTime = createTime;
		this.operId = operId;
		this.remark = remark;
		this.perids = perids;
		this.orgName = orgName;
		this.operName = operName;
	}
	
	
	
}
