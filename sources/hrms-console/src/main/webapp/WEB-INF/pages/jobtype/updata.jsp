<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jobtype/update" method="post">
    <input type="hidden" name="jtid" value="${jobType.jtid}">
    父类型：<select name="bJJtid">
    <c:forEach items="${jobtypeList}" var="jobtype">
        <c:if test="${jobType.bJJtid==jobtype.jtid}">
            <option value="${jobtype.jtid}" selected="selected">${jobtype.jtname}</option>
        </c:if>
        <c:if test="${jobType.bJJtid!=jobtype.jtid}">
            <option value="${jobtype.jtid}" >${jobtype.jtname}</option>
        </c:if>
    </c:forEach>
</select><br>
    新类型名称：<input name="jtname" value="${jobType.jtname}">原名称：${jobType.jtname}<br>
    热度排名：<input name="jorder" value="${jobType.jorder}">(使用整数)原热度：${jobType.jorder}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>