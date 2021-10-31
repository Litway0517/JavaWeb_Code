<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/31
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出数据</title>
</head>
<body>

<%--    jsp页面输出数据 -> 表达式脚本--%>

    <%
        request.setAttribute("key1", "存放的值");
    %>


    jsp界面的输出方式是 -> <%=request.getAttribute("key1")%><br/>
    EL的输出方式是 -> ${key1}<br/>
    EL的输出方式是, 若不存在的话 -> ${key}<br/>


</body>
</html>
