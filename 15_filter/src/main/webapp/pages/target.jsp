<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-1-20
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        System.out.println("target界面执行了");
        System.out.println("target界面的线程名称: " + Thread.currentThread().getName());
        System.out.println("target界面中的request域是共享的(因为这是一次请求): " + request.getParameter("username"));
    %>
</body>
</html>
