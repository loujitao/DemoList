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
    <form action="${pageContext.request.contextPath}/exptime/addExptime" method="post">
       添加年限:<input type="text" name="yname">

        <input type="submit" value="提交">
    </form>
<br>
<a href="${pageContext.request.contextPath}/exptime/queryAll">返回</a>
</body>
</html>
