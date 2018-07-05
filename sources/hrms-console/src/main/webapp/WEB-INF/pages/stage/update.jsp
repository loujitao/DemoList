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
    <title>修改公司发展阶段</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/stage/update" method="post">
    <input type="hidden" name="stid" value="${stage.stid}">
    新名称：<input name="stname" value="${stage.stname}">原名称：${stage.stname}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
