<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/8/4
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/status/update" method="post">
        <input type="hidden" name="stid" value="${status.stid}">
        求职状态：<input name="stname" value="${status.stname}">
        <input type="submit" value="提交">

        <%--<select name="stname">
        <c:forEach items="${sList}" var="state">
            <c:if test="${status.stid==state.state}">
            <option value="${state.stid}" selected="selected">${state.stname}</option>
            </c:if>
            <c:if test="${status.stid!=state.state}">
                <option value="${state.stid}" >${state.stname}</option>
            </c:if>
        </c:forEach><br>--%>
    </select>
    </form>
</body>
</html>
