<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath}/resumetype/add" method="post">
    接受简历类型名称：<input name="rtname"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>