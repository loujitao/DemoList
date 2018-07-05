<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/2
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>add</title>
</head>
<body>
${msg}
    <form action="${pageContext.request.contextPath}/city/addCity" method="post">
       城市名：<input type="text" name="cname">

        <input type="submit" value="提交">
    </form>
</body>
</html>
