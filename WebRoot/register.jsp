
<%@ page language="java" contentType="text/html; charset=UTF-8"  
pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<%
String path = request.getContextPath();
%>  
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.4.min.js"></script> 
<script src="<%=path %>/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=path %>/js/messages_zh.min.js" type="text/javascript"></script>
    <title>Register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="register page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form name="form1" action="reguser" method="post">
<table width="300" border="1">
    <tr>
        <td colspan="2">注册新用户</td>
    </tr>
    <tr>
            <td>用户名</td>
            <td><input type="text" name="login_name" size="10" required minlength="2"></td>
    </tr>
    <tr>
            <td>密码</td>
            <td><input type="password" name="password" size="10" required minlength="2"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" name="submit"
            value="注册">
    </tr>
</table>
</form>
    <h5><a href="getAllUser">进入用户管理页</a></h5>
  </body>
</html>
