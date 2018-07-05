<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/massagetype/update" method="post">
    <input type="hidden" name="mid" value="${massageType.mid}">
    父类型：<select name="bMMid">
    <c:forEach items="${massagetypeList}" var="jobtype">
        <c:if test="${massageType.bMMid==jobtype.mid}">
            <option value="${jobtype.mid}" selected="selected">${jobtype.mname}</option>
        </c:if>
        <c:if test="${massageType.bMMid!=jobtype.mid}">
            <option value="${jobtype.mid}" >${jobtype.mname}</option>
        </c:if>
    </c:forEach>
</select><br>
    新类型名称：<input name="mname" value="${massageType.mname}">原名称：${massageType.mname}<br>
    接受状态：<c:if test="${massageType.isjie==true}">
            <input type="radio" name="isjie" value="${1==1}" checked="checked"> 接受 <input type="radio" name="isjie" value="${1>2}"> 屏蔽
            </c:if>
            <c:if test="${massageType.isjie==false}">
        <input type="radio" name="isjie" value="${1==1}" > 接受 <input type="radio" name="isjie" value="${1>2}" checked="checked"> 屏蔽
            </c:if>
    <input type="submit" value="提交">
</form>
</body>
</html>