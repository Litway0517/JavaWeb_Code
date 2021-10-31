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

<%--    <h2>四大域对象</h2>--%>
<%--    <hr>--%>
<%--    <%--%>
<%--        // 向四个域中保存对象--%>
<%--        pageContext.setAttribute("key", "pageContext");--%>
<%--        request.setAttribute("key", "request");--%>
<%--        session.setAttribute("key", "session");--%>
<%--        application.setAttribute("key", "application");--%>
<%--    %>--%>
<%--    <br/><br/>--%>
<%--    pageContext域中是否有值 -> <%=pageContext.getAttribute("key")%><br/>--%>
<%--    request -> <%=request.getAttribute("key")%><br/>--%>
<%--    session -> <%=session.getAttribute("key")%><br/>--%>
<%--    application -> <%=application.getAttribute("key")%><br/>--%>

<%--    <%--%>
<%--        request.getRequestDispatcher("/pages/scope2.jsp").forward(request, response);--%>
<%--    %>--%>

<%--    第二种 将请求转发的方式, 和上面的效果一样--%>
<%--
    实际上这里面已经跳转了, 只不过是因为scope.jsp和scope2.jsp两个界面差不多, 所以你没发现而已
    跳转的时候, 地址栏不会出现改变, 而是界面呈现的内容直接发现了改变
--%>
    <jsp:forward page="/pages/scope2.jsp"></jsp:forward>


</body>
</html>
