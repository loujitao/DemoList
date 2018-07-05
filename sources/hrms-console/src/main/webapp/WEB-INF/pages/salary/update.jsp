<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/4
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>期望薪资修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/salary/update" method="post">
    <input type="hidden" name="sid" value="${salary.sid}">
    新类型名称：<input name="salary" value="${salary.salary}">原名称：${salary.salary}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
