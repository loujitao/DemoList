<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tag/add" method="post">
    父类型：<select name="bTTid">
    <c:forEach items="${tagList}" var="jobtype">
            <option value="${jobtype.tid}">${jobtype.tname}</option>
    </c:forEach>
            </select><br>
    新类型名称：<input name="tname"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>