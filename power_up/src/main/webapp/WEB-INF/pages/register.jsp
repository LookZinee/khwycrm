<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

	<form action="user/register" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" name="name" >
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input type="text" name="pwd" >
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<input type="submit" value="注册" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>