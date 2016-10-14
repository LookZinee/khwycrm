<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../commons/head.jsp" %>
</head>
<body>
<nav class="breadcrumb">
	系统管理 <span class="c-gray en">&gt;</span> 角色管理 <span class="c-gray en">&gt;</span> 授权
	<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >刷新</a></nav>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-user-character-add">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>角色编码：</label>
			<div class="formControls col-5">
				<label class="form-label l">admin</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>创建时间：</label>
			<div class="formControls col-5">
				<label class="form-label l">2016-08-09:12:39:05</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>最后操作人：</label>
			<div class="formControls col-5">
				<label class="form-label l">XXXX</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>最后修改时间：</label>
			<div class="formControls col-5">
				<label class="form-label l">2016-08-09:12:39:05</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">授权功能菜单：</label>
			<div class="formControls col-10">
				<dl class="permission-list">
					<dt>
						<label>
							<input type="checkbox" value="" name="user-Character-0" id="user-Character-0">
							系统设置</label>
					</dt>
					<dd>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-0">
							角色管理</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-1">
							组织结构</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-2">
							员工管理</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-3">
							公告管理</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-4">
							个人信息</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-4">
							基础信息</label>
						<label class="">
							<input type="checkbox" value="" name="user-Character-0-0-0" id="user-Character-0-0-4">
							数据字典</label>
					</dd>
				</dl>
			</div>
		</div>
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button type="submit" class="btn btn-primary radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i>授权</button>
				<button type="button" onclick="javascript:history.go(-1);" class="btn btn-secondary radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i>返回</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../commons/script.jsp" %>
</body>
</html>