<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../commons/head.jsp" %> %>
</head>
<body>
<nav class="breadcrumb">
	系统管理 <span class="c-gray en">&gt;</span> 角色管理 <span class="c-gray en">&gt;</span> 修改
	<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >刷新</a></nav>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-user-character-add">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>角色编码：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="admin" id="user-name" name="user-name" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="user-name" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>所属部门：</label>
			<div class="formControls col-2">
				<span class="select-box">
					<select class="select">
						<option>总经办</option>
						<option>综合部</option>
						<option>市场发展部</option>
						<option>业务一部</option>
						<option>业务二部</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>备注信息：</label>
			<div class="formControls col-5">
				<textarea class="textarea" rows="5" cols="50"></textarea>
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