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
<title>Insert title here</title>
<script type="text/javascript">
	function toRegister(){
		window.location="user/toRegister";
	}
</script>
</head>
<body>
	<form action="user/login" method="post">
		用户名：<input type="text" name="name" value="${username }"><br/>
		密码： <input type="text" name="pwd"><br/>
		<input type="submit" value="登录">
		<input type="button" onclick="toRegister();" value="注册">
	</form>
</body>
</html>