<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/resumetype/update" method="post">

    <input type="hidden" name="rtid" value="${resumetype.rtid}">

    接受简历类型名称：<input name="rtname" value="${resumetype.rtname}">原名称：${resumetype.rtname}<br>
    <input type="submit" value="提交">
</form>
</body>
</html>