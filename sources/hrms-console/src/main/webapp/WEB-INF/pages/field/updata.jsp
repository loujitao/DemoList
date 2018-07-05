<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/field/update" method="post">
    <input type="hidden" name="fid" value="${field.fid}">
    修改公司所属领域:<input name="fname" >原名称:${field.fname}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>