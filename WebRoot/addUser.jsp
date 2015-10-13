
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String path = request.getContextPath();
%>  
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.4.min.js"></script> 
<script src="<%=path %>/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=path %>/js/messages_zh.min.js" type="text/javascript"></script>
<title>Admin adding user</title>
<script type="text/javascript">
	function addUser() {
		var form = document.forms[0];
		form.action = "addUser";
		form.method = "post";
		form.submit();
	}
</script>
</head>
<body>
	<h1>添加用户</h1>
	<form action="" name="userForm">
		登陆名<input type="text" name="login_name" required minlength="2">
		密码<input type="text" name="password" required minlength="2">
		<input type="button" value="添加" onclick="addUser()">
	</form>
</body>
</html>
