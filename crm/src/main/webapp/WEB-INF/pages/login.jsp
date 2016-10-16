<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="commons/head.jsp" %>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
  	<div id ="tishiid" style="text-align: center;color:red;display: none"></div>
    <form class="form form-horizontal" method="post">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="usernameid" name="username" value="zinee" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="passwordid" name="password" value="123456" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-8 col-offset-3">
          <input class="input-text size-L" type="text" id="validateCodeid" placeholder="验证码" onblur="if(this.value==''){this.value=''}" onclick="if(this.value==''){this.value='';}" style="width:150px;">
          <img src="code" id="validateCode"/> <a id="kanbuq" style="text-decoration: none;" onclick="changeCode()" href="javascript:;">看不清，换一张</a> </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">使我保持登录状态</label>
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="" type="button" onclick="validate_code();" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<%@ include file="commons/script.jsp" %>
<div class="footer">Copyright khwy by J04</div>
<script type="text/javascript" src="${ctx}/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript">
	function changeCode(){
		var timestamp = (new Date()).valueOf();
		$("#validateCode").attr("src","code?timestamp="+timestamp);
	}
	function validate_code(){
		var username = $("#usernameid").val();
		var password = $("#passwordid").val();
		var validateCodeid = $("#validateCodeid").val();
		var online = $("#online").is(":checked");
		alert(online);
		$.ajax({
			url:"user/login",
			type:"POST",
			dataType:"text",
			data:{username:username,
				password:password,
				code:validateCodeid,
				online:online
					},
			success:function(result){
				if(result != "success"){
					$("#tishiid").text(result);
					$("#tishiid").show();
					changeCode();
				}
				if(result == "success"){
					window.location="index"
				}
			}
			
		});
	}
</script>
</html>