<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jobtype/add" method="post">
    父类型：<select name="bJJtid">
    <c:forEach items="${jobtypeList}" var="jobtype">
            <option value="${jobtype.jtid}">${jobtype.jtname}</option>
    </c:forEach>
            </select><br>
    新类型名称：<input name="jtname"><br>
    热度排名：<input name="order">(使用整数)<br>
    <input type="submit" value="提交">
</form>
</body>
</html>