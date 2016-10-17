<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../commons/head.jsp" %>
</head>
<body>
<nav class="breadcrumb">
	系统管理 <span class="c-gray en">&gt;</span>组织机构 <span class="c-gray en">&gt;</span> 添加
	<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >刷新</a></nav>
<div class="pd-20">
	<form action="${ctx }/sys/org/edit" method="post" class="form form-horizontal" id="form-user-character-add">
		<input type="hidden" name="orgId" value="${org.orgId }">
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>组织编码：</label>
			<div class="formControls col-5">
				<input type="text" name="orgCode" class="input-text" value="${org.orgCode }" placeholder="admin" id="user-name" name="user-name" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>组织简称：</label>
			<div class="formControls col-5">
				<input type="text" name="simpleName" class="input-text" value="${org.simpleName }" placeholder="" id="user-name" name="user-name" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>组织全称：</label>
			<div class="formControls col-5">
				<input type="text" name="fullName" class="input-text" value="${org.fullName }" placeholder="" id="user-name" name="user-name" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>部门简介：</label>
			<div class="formControls col-5">
				<textarea class="textarea" name="introduce" rows="5" cols="50">${org.introduce }</textarea>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>备注信息：</label>
			<div class="formControls col-5">
				<textarea class="textarea" name="remark" rows="5" cols="50">${org.remark }</textarea>
			</div>
		</div>
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button type="submit" class="btn btn-primary radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i>保存</button>
				<button type="button" onclick="javascript:history.go(-1)" class="btn btn-secondary radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i>返回</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../commons/script.jsp" %>
</body>
</html>