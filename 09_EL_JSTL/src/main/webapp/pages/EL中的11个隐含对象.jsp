<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>11个隐含对象</title>
</head>
<body>

    <%
        out.print("变量 类型 作用\n" +  "<br/>" +
                "pageContext PageContextImpl 它可以获取 jsp 中的九大内置对象\n" + "<br/>" +
                "pageScope Map<String,Object> 它可以获取 pageContext 域中的数据\n" + "<br/>" +
                "requestScope Map<String,Object> 它可以获取 Request 域中的数据\n" + "<br/>" +
                "sessionScope Map<String,Object> 它可以获取 Session 域中的数据\n" + "<br/>" +
                "applicationScope Map<String,Object> 它可以获取 ServletContext 域中的数据\n" + "<br/>" +
                "param Map<String,String> 它可以获取请求参数的值\n" + "<br/>" +
                "paramValues Map<String,String[]> 它也可以获取请求参数的值，获取多个值的时候使用。\n" + "<br/>" +
                "header Map<String,String> 它可以获取请求头的信息\n" + "<br/>" +
                "headerValues Map<String,String[]> 它可以获取请求头的信息，它可以获取多个值的情况\n" + "<br/>" +
                "cookie Map<String,Cookie> 它可以获取当前请求的 Cookie 信息\n" + "<br/>" +
                "\n" + "<br/>" +
                "使EL和jsp连接了起来\n" + "<br/>" +
                "\n" + "<br/>" +
                "返回的使cookie对象");
    %>




</body>
</html>
