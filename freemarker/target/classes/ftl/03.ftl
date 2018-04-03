<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Insert</title>
</head>
<body>
<h1>${user.id}------${user.name}-----${user.age}</h1>

<#if user.age lt 12>
    ${user.name}小孩
<#elseif user.age lt 18>
    ${user.name}未成年
<#else>
    ${user.name}成年
</#if>

</body>
</html>