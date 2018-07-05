<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>update</title>
</head>
<body>
当前城市名:${city.cname}
<form action="${pageContext.request.contextPath}/city/updateCity" method="post">
    <input type="hidden" name="cid" value="${city.cid}"/>
    修改城市名为:<input type="text" name="cname"/>
    <input type="submit" value="提交">
</form>
<br>
<a href="${pageContext.request.contextPath}/city/selectAllCity">放弃修改,返回</a>
</body>
</html>