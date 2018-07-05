<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/massagetype/add" method="post">
    父类型：<select name="bMMid">
    <c:forEach items="${massagetypeList}" var="jobtype">
            <option value="${jobtype.mid}">${jobtype.mname}</option>
    </c:forEach>
            </select><br>
    新类型名称：<input name="mname"><br>
    接受状态：  <input type="radio" name="isjie" value="${1==1}"> 接受 <input type="radio" name="isjie" value="${1>1}"> 屏蔽
    <input type="submit" value="提交">
</form>
</body>
</html>