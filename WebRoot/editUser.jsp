
<%@ page language="java" contentType="text/html; charset=UTF-8"  
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>
<%
String path = request.getContextPath();
%>  
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.4.min.js"></script> 
<script src="<%=path %>/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=path %>/js/messages_zh.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
<h1>编辑用户</h1>  
<form action="<%=path%>/updateUser" name="userForm" method="post">  
    <input type="hidden" name="user_id" value="${user.user_id }">  
    登陆名：<input type="text" name="login_name" value="${user.login_name }">  
    密码：<input type="text" name="password" value="${user.password }">  
    <input type="submit" value="编辑" >  
</form>  
</body>  
</html> 