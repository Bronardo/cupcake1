
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.4.min.js"></script> 
<script src="<%=path %>/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=path %>/js/messages_zh.min.js" type="text/javascript"></script>

<title>登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is the login page which replaced the index page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
$.validator.setDefaults({
	submitHandler:function() {
		alert("submitted!");
	}
});
$().ready(function() {
 	$("#form1").validate({
 		debug:true,
   		rules:{
 			cid:"required",
 			cpw:{
 				required:true,
 				minlength:2
 			}
 		},
 		
 		messages:{
 			cid:"请输入用户名",
 			cpw:{
 				required:"请输入密码",
 				minlength:JQuery.format("密码不能小于 {0}个字符 ")
 			}
 		}
 	});
});
</script>

</head>
<body>
	<p><a href="<%=path %>/druid">Druid 监控入口</a></p>
	<form name="form1" action="<%=path%>/validateLogin" method="post">
		<table width="300" border="1">
			<tr>
				<td colspan="2">登录窗口</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="cid" name="id" size="10" required minlength=2></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="cpw" name="pw" size="10" required minlength=2></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="登录">
					<a href="<%=path%>/reg">注册新用户</a></td>
			</tr>
		</table>
	</form>
	<h5>
		<a href="getAllUser">进入用户管理页22</a>
	</h5>
	<p>
		current id:<%=session.getAttribute("id") %>
		current pw:<%=session.getAttribute("pw") %>
	</p>
</body>
</html>
