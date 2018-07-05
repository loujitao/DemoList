<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/4
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司规模列表</title>
</head>
<body>

${msg}
<form action="${pageContext.request.contextPath}/scale/addScale" method="post">
    公司规模：<input type="text" name="scontext"></br></br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/scale/queryAll"><input type="button" value="取消"></a>
</form>

</body>
</html>
