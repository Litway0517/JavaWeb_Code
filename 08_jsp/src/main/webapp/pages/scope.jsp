<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/27
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope测试四大域对象的范围</title>
</head>
<body>

    <h2>四大域对象</h2>
    <hr>
    <%
        // 向四个域中保存对象
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    <br/><br/>
    pageContext域中是否有值 -> <%=pageContext.getAttribute("key")%><br/>
    request -> <%=request.getAttribute("key")%><br/>
    session -> <%=session.getAttribute("key")%><br/>
    application -> <%=application.getAttribute("key")%><br/>

    <%
        request.getRequestDispatcher("/pages/scope2.jsp").forward(request, response);
    %>


</body>
</html>
