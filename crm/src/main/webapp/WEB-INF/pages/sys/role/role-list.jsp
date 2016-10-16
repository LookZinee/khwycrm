<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../commons/head.jsp" %>
</head>
<body>
<nav class="breadcrumb">系统管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >刷新</a></nav>
<div class="pd-20">
	<div class="text-c">
		角色名称：
		<input type="text" name="" id="" placeholder="角色名称" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit">查询</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="r">
			<a class="btn btn-primary radius" href="${ctx}/sys/role/add">添加</a>
			<a class="btn btn-danger radius" href="${ctx}/sys/role/edit">修改</a> 
			<a class="btn btn-primary radius" href="javascript:;" onclick="roleDel()">删除</a>
			<a class="btn btn-danger radius" href="${ctx}/sys/role/authc">授权</a> 
		</span></div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="12"></th>
					<th width="25"></th>
					<th width="25">角色名称</th>
					<th width="80">所属部门</th>
					<th width="80">最后修改时间</th>
					<th width="80">操作人</th>
					<th width="80">备注说明</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>1</td>
					<td><input type="radio" value="" name=""></td>
					<td>系统管理员</td>
					<td>综合部</td>
					<td>2013-10-15 09:24:55</td>
					<td>尚鸿运</td>
					<td>默认角色，勿删</td>
				</tr>
				<tr class="text-c">
					<td>2</td>
					<td><input type="radio" value="" name=""></td>
					<td>系统管理员</td>
					<td>综合部</td>
					<td>2013-10-15 09:24:55</td>
					<td>尚鸿运</td>
					<td>默认角色，勿删</td>
				</tr>
				<tr class="text-c">
					<td>3</td>
					<td><input type="radio" value="" name=""></td>
					<td>系统管理员</td>
					<td>综合部</td>
					<td>2013-10-15 09:24:55</td>
					<td>尚鸿运</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../../commons/script.jsp" %>
</body>
<script type="text/javascript">
	//角色删除
	function roleDel(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			layer.msg('已删除!');
		});
	}
</script>
</html>