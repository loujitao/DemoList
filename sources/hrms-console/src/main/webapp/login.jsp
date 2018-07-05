<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>

<title>企业信息管理系统_用户登录</title>

 </head>

<body>
 <form action="${pageContext.request.contextPath}/login" method="post">
   用户名：<input type="text" name="mname"><br>
   密码：<input type="password" name="mpwd"><br>
   <input type="submit" value="登录">
 </form>
</body>
</html>
