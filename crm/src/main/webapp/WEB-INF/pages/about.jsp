<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="commons/head.jsp" %>
</head>
<body>
	<div class="pd-20" style="padding-top: 20px;">
		<p class="f-20 text-success">
			客户关系管理系统主要用于日常工作中客户资源维护与管理等任务。<br>
			主要包括系统设置、销售管理、客户管理、服务管理、订单管理、合同管理、统计分析等模块，<br>
			可满足日常客户资源维护、销售数据分析、潜在和有价值客户分析等需求。<br>
			<shiro:notAuthenticated>
	记住我
</shiro:notAuthenticated>
		</p>
	</div>
</html>