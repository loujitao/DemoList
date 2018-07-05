<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html  >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--

  body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
  }

  #top {
	   background: url("${pageContext.request.contextPath}/static/images/main_03_1.png");
	   height:100px;
	   width:100%;
	}
	
	#top_left {
	   background: url("${pageContext.request.contextPath}/static/images/main_42.gif") repeat-y;
	   height:61px;
	   width:100%;
	   float:left;
	   
	}
	
	#log{
	   background: url("${pageContext.request.contextPath}/static/images/log_fendou.png") no-repeat;
	   height:61px;
	   width:241px;
	   left:40px;
	   top:20px;
	   position:absolute;
	}
	
	#browse_fun{
	position:absolute;
	right:328px;
	top:44px;
	width:367px;
	height:23px;
	background: url("${pageContext.request.contextPath}/static/images/main_12.gif") no-repeat;
	}
	
	#time{
	position:absolute;
	right:41px;
	top:25px;
	color: #43860c;
	font-size: 12px;
	}
	
	.font-style1{
	   color: #43860c;
	   font-size: 12px;	
	}

-->
</style></head>

<body>
	 <div id="top">
	     <div id="top_left"></div>
	     <!-- log -->
	     <div id="log"></div>
	     <!-- 浏览器导航 -->
       <table id="time">
       <tr>
		   <td>欢迎您：${manager}</td>
         <td>日期：2010年05月26日 星期三</td></tr></table>
	 </div>
</body>
</html>
