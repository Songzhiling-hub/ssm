<%--
  Created by IntelliJ IDEA.
  User: liche
  Date: 2020/4/29
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/ssm/user/regist" method="post">
        用户名：<input name="username" type="text">
        密码：<input name="password" type="password">
        <input type="submit">
    </form>
</body>
</html>
