<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath}/field/add" method="post">
    新增行业领域:<input name="fname"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>