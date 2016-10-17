<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../commons/head.jsp" %>
</head>
<body>
<nav class="breadcrumb">系统管理 <span class="c-gray en">&gt;</span> 组织机构 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >刷新</a></nav>
<div class="pd-20">
	<div class="text-c">
		名称：
		<input type="text" name="" id="" placeholder="名称" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit">查询</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="r">
			<a class="btn btn-primary radius" href="${ctx}/sys/org/add">添加</a>
			<a class="btn btn-danger radius" onclick="orgToEdit();">修改</a> 
			<a class="btn btn-primary radius" href="javascript:;" onclick="orgDel()">删除</a>
		</span></div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="12"></th>
					<th width="25">编号</th>
					<th width="25">部门代码</th>
					<th width="25">简称</th>
					<th width="25">全称</th>
					<th width="80">介绍</th>
					<th width="80">操作人</th>
					<th width="80">备注说明</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="each" varStatus="status">
					<tr class="text-c">
					<td><input type="radio" name="orgid" value="${each.orgId }" name=""></td>
					<td>${status.index }</td>
					<td>${each.orgCode }</td>
					<td>${each.simpleName }</td>
					<td>${each.fullName }</td>
					<td>${each.introduce }</td>
					<td>${each.user.username }</td>
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
	function orgDel(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			var orgid = $("input[name='orgid']:checked").val();
				alert(orgid);
			$.ajax({
				url:"${ctx}/sys/org/del",
				data:{orgId:orgid},
				dataType:"text",
				type:"POST",
				success:function(data){
					if(data == "success"){
						layer.msg('已删除!');
						window.location="${ctx}/sys/org/list";
					}else if(data == "error"){
						layer.msg("删除失败！");
						widnow.location="error";
					}
				}
			});
		});
	}
	function orgToEdit(obj,id){
		var orgid = $("input[name='orgid']:checked").val();
		alert(orgid);
		window.location="${ctx}/sys/org/toEdit?orgId="+orgid;				
	}	

</script>
</html>