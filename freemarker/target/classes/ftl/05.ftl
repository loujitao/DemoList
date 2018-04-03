<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
<hr/>
<#list users as user>
${user.id}---------${user.name}-------${user.age}<br/>
</#list>
</body>
</html>