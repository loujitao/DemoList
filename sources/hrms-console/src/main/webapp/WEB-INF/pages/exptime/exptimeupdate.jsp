<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>update</title>
</head>
<body>
当前毕业年限:${exptime.yname}
<form action="${pageContext.request.contextPath}/exptime/updateExptime?yind=${exptime.yind}" method="post">
    修改城市名为:<input type="text" name="yname"/>

    <input type="submit" value="提交">
</form>
<br>
<a href="${pageContext.request.contextPath}/exptime/queryAll">放弃修改,返回</a>
</body>
</html>