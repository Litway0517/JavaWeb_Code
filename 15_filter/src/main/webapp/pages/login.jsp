<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-1-19
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    这里是登陆界面: login.jsp
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        账户: <input type="text" name="username" value="" /> <br>
        密码: <input type="password" name="password" value="" /> <br>
        <input type="submit" value="提交">

    </form>

</body>
</html>

