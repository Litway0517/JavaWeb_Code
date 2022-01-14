<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>login</title>
</head>
<body>
    <form action="registServlet" method="get">
        用户名: <input type="text" name="username"> <br/>
        验证码: <input type="text" style="width: 60px" name="code">
        <img src="http://localhost:8080/tmp/kaptcha.jpg" alt="服务器失联, 请稍后重试" style="width: 75px; height: 28px"><br/>
<%--        密码: <input type="password" name="password"><br/>--%>
        <input type="submit" value="提交">


    </form>

</body>
</html>
