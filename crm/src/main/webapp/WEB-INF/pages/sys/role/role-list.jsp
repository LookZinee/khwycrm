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
			<a class="btn btn-primary radius" href="${ctx}/sys/role/toadd">添加</a>
			<a class="btn btn-danger radius" onclick="roleEdit();">修改</a> 
			<a class="btn btn-primary radius" href="javascript:;" onclick="roleDel()">删除</a>
			<a class="btn btn-danger radius" href="javascript:;" onclick="toAutho()">授权</a> 
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
				<c:forEach items="${list }" varStatus="status" var="each">
					<tr class="text-c" id="role_id_${each.roleId }">
					<td>${status.index }</td>
					<td><input type="radio" value="${each.roleId }" name="roleId"></td>
					<td>${each.roleName }</td>
					<td>${each.orgName }</td>
					<td><fmt:formatDate value="${each.createTime }" type="both"/> </td>
					<td>${each.operName }</td>
					<td>${each.remark }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="../../commons/script.jsp" %>
</body>
<script type="text/javascript">
	//角色删除
	function roleDel(obj,id){
		var roleid = $("input[name='roleId']:checked").val();
		if(roleid == null){
			layer.msg('请选择要删除的角色！');
			return false;
		}
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				url:'${ctx}/sys/role/del',
				type:'POST',
				data:{
					'roleId':roleid
				},
				dataType:'text',
				success:function(result){
					$("#role_id_"+roleid).remove();
					layer.msg('删除成功');
				},
				error:function(result){
					alert(result);
					layer.alert('删除失败');
				}
			});
		});
	}
	function roleEdit(){
		var roleId = $("input[name='roleId']:checked").val();
		alert(roleId);
		if(!roleId){
			layer.alert("请选择组织机构");
		}else{
			location.href="${ctx}/sys/role/toedit?roleId="+roleId;
		}
	}
	function toAutho(){
		var roleid = $("input[name='roleId']:checked").val();
		if(roleid == null){
			layer.alert("请先选择角色!");
			return false;
		}
		window.location="${ctx}/sys/role/auth?roleId="+roleid;

	}
</script>
</html>