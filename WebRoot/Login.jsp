
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
<!--  
<script src="<%=path %>/js/messages_zh.min.js" type="text/javascript"></script>
-->
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

$().ready(function() {
 	$("#form1").validate({
   		rules:{
 			id:{
 				required:true,
 				minlength:2
 			},
 			pw:{
 				required:true,
 				minlength:2
 			}
 		},
 		
 		messages:{
 			id:{
 				required:"请输入用户名",
 				minlength:"用户名长度不能小于2个字符"
 			},
 			pw:{
 				required:"请输入密码",
 				minlength:"密码不能小于2个字符 "
 			}
 		}
 	});
});

</script>
</head>
<body>
	<p><a href="<%=path %>/druid">Druid 监控入口</a></p>
	<form class="cmxform" id="form1" action="<%=path%>/validateLogin" method="post">
		<table width="500" border="1">
			<tr>
				<td colspan="2">登录窗口</td>
			</tr>
			<tr>
				<td><lable for="cpw">用户名</lable></td>
				<td><p><input type="text" id="cid" name="id" size="10"></p></td>
			</tr>
			<tr>
				<td><lable for="cpw">密码</lable></td>
				<td><input type="password" id="cpw" name="pw" size="10"></td>
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
