<%@ page language="java" contentType="text/html; charset=UTF-8"  
pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>
<%
    String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/js/jquery-2.1.4.min.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>用户管理</title>  
<script type="text/javascript">  

	function del(id) {
		$.get("delUser?id=" + id, function(data) {
			if ("success" == data.result) {
				alert("删除成功");
				window.location.reload();
			} else {
				alert("删除失败");
			}
		});
	}

	$(document).ready(
			function() {
				jQuery.ajax({
					type : 'GET',
					contentType : 'application/json',
					url : 'getAllUser/jsonAllUser',
					dataType : 'json',
					success : function(data) {
						if (data) {
							$('#jsonDiv').html("共" + data.length + "条数据。<br/>");
							$.each(data, function(i, item) {
								$('#jsonDiv').append(
										"ID：" + item.user_id +
										"，用户名："+ item.login_name +
										"，密码："+ item.password+"<br/>");
							});
						}
					},
					error : function() {
						alert("error")
					}
				});
			});
</script>  
</head>  
<body>  
    <h6><a href="toAddUser">添加用户</a></h6>  
    <table border="1">  
        <tbody>  
        <tr>  
            <th>登陆名</th>  
            <th>密码</th>  
            <th>操作</th>  
        </tr>  
        <c:if test="${!empty userList }">  
            <c:forEach items="${userList }" var="user">  
                <tr>  
                    <td>${user.login_name }</td>  
                    <td>${user.password }</td>  
                    <td>  
                        <a href="<%=path%>/getUser?id=${user.user_id }">编辑</a>  
                        <a href="javascript:del('${user.user_id }')">删除</a>  
                    </td>  
                </tr>               
            </c:forEach>  
        </c:if>  
    </tbody>  
</table>  
    <p>current id:<%=session.getAttribute("id")%> </p>
    <p><a href="<%=path%>/getAllUser/jsonAllUser">Json测试</a>  </p>
    <p id="jsonDiv">e</p>
</body>  
</html>  