<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-1-12
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>免用户名登录</title>

    <base href="http://localhost:8080/" />
</head>
<body>

    <form action="loginServlet/action=login" method="POST">
        <input type="hidden" name="">

        <label>
            用户名: <input type="text" name="username" value="">
        </label>
        <label>
            密 码: <input type="text" name="password" value="">
        </label>

        <input type="submit" value="提交">




    </form>

</body>
</html>
