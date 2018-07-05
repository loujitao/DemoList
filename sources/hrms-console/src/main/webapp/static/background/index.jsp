<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html  >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用奋斗人力资源管理系统</title>
</head>
<frameset rows="95,*,20" cols="*" framespacing="1" border="1">
	<frame src="${pageContext.request.contextPath}/static/background/top.jsp" name="top" scrolling="no" marginwidth="1" marginheight="1" frameborder="0">

	<frameset cols="180,*" frameborder="NO" border="0" framespacing="0" >
		<frame src="${pageContext.request.contextPath}/static/background/left.jsp" name="left" scrolling="auto" noresize>
		<frame src="${pageContext.request.contextPath}/static/background/welcome.jsp" name="mainFrame">
	</frameset>

	<frame src="${pageContext.request.contextPath}/static/background/down.jsp.jsp" name="bottom" frameborder="0" scrolling="no" marginwidth="1" marginheight="1" >

	<noframes>
		<body topmargin="0" leftmargin="0" bgcolor="#b5daff">
		</body>
	</noframes>
</frameset>
</html>
