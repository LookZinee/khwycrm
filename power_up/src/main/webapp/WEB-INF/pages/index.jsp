<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function createAjax(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		return xmlhttp;
	}
	function listUser(th){
		var num = th.value;
		var xmlhttp = createAjax();
		xmlhttp.open("get","http://localhost:8080/user/find?pageSize="+num+"&currentPage=1",true);
		
		xmlhttp.onreadystatechange=function()
		  {
		
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
			  	var data = xmlhttp.responseText;
			  	var users=eval('('+data+')'); 
			  	var table = document.getElementById("tableid");
			  	var tr = "";
		   		for(var i = 0;i<users.length;i++){
		   			tr+="<tr><td>"+users[i].id+"</td><td>"+users[i].name+"</td><td>"+users[i].pwd+"</td></tr>"
		   		}
		   		table.innerHTML= "<tr><th>编号</th><th>用户名</th><th>密码</th></tr>"+tr;
		    }
		  }
		xmlhttp.send(null);
	}
	function shouye(){
		var pageSize = document.getElementById("usernum");
		window.location="user/find?pageSize="+pageSize+"&"
	}
</script>
</head>
<body>
	<div style="margin-left: 100px">
		每页个数： <input type="radio" name="usernum" value="2" checked="checked" onclick="listUser(this);"> 2 &nbsp;
		 <input type="radio" name="usernum" value="3" onclick="listUser(this);"> 3 &nbsp;
		  <input type="radio" name="usernum" id="input3" value="4" onclick="listUser(this);"> 4 &nbsp;
		<table id="tableid">
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>密码</th>
			</tr>
			<c:forEach items="${userList }" var="each">
				<tr>
					<td>${each.id }</td>
					<td>${each.name }</td>
					<td>${each.pwd }</td>
				</tr>
			</c:forEach>
		</table>
		<a onclick="shouye();">首页</a>
	</div>
</body>
</html>