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

    <base href="http://localhost:8080/13_cookie_session/" />
</head>
<body>

    <form action="loginServlet?action=login" method="POST">

        <label>
            用户名: <input type="text" name="username" value="${ cookie.username.value }">
        </label> <br/><br/>
        <label>
            密  &nbsp;&nbsp;码: <input type="text" name="password" value="">
        </label> <br/>

        <input type="submit" value="提交">




    </form>

</body>
</html>
