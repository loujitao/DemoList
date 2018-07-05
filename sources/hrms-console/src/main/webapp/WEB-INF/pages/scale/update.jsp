<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/4
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公司规模</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/scale/update" method="post">
    <input type="hidden" name="sid" value="${scale.sid}">
    新名称：<input name="scontext" value="${scale.scontext}">原名称：${scale.scontext}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
