<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/2
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext测试</title>
</head>
<body>

    输出一下pageContext, 结果 -> org.apache.jasper.runtime.PageContextImpl@4c4b0758 -> ${ pageContext }  <br/>

    <br/>
    <%--
        request.getScheme() -> 该方法用来获取协议
        request.getServerName() -> 获取请求的服务器ip或域名
        request.getServerPort() -> 获取请求的服务器端口号port
        request.getContextPath() -> 获取当前工程的路径
        request.getMethod() -> 获取请求的方式
        request.getRemoteHost() -> 获取客户端的ip地址
        session.getId() -> 获取客户端的ip地址

    --%>
    <%--  这里面的request是, jsp的九大内置对象, 用九大内置对象结合表达式脚本输出信息当然合理  --%>
    <h2>使用jsp本身的九大内置对象结合表达式脚本输出数据</h2>
    <hr>
    1. 协议 -> <%=request.getScheme()%>  <br/>
    2. ip地址 -> <%=request.getServerName()%>  <br/>
    3. 服务器端口 -> <%=request.getServerPort()%>  <br/>
    4. 当前工程路径名 -> <%=request.getContextPath()%> <br/>
    5. 请求的方法 -> <%=request.getMethod()%> <br/>
    6. 会话id -> <%=session.getId()%> <br/>

    <%-- 代码脚本, 先在域中存放数据, 然后再获取 --%>
    <%
        request.setAttribute("req", "req");
        session.setAttribute("session", "session");
        application.setAttribute("application", "application");
    %>

    <h2>使用jsp本身的九大内置对象结合EL表达式输出数据</h2>
    <hr>
    ${ requestScope.req }<br/>
    ${ sessionScope.session }<br/>
    ${ applicationScope.application }<br/>
    ${ pageScope.pageContext }<br/>



    <h2>使用pageContext对象结合EL表达式输出数据</h2>
    <hr>
    1. 协议 -> ${ pageContext.request.scheme } <br/>
    2. 服务器ip -> ${ pageContext.request.serverName } <br/>
    3. 服务器端口号 -> ${ pageContext.request.serverPort } <br/>
    4. 当前工程路径 -> ${ pageContext.request.contextPath } <br/>
    5. 获取请求的方法 -> ${ pageContext.request.method } <br/>
    6. 获取远程客户端的ip -> ${ pageContext.request.remoteHost } <br/>
    7. 获取会话的id -> ${ pageContext.session.id } <br/>
    <br/>
    上面写的pageContext.request.scheme这些东西, 最后直接是scheme, 实际上就是getScheme(), Bean对象的getter/setter方法原理
    和request.getScheme()差不多.




</body>
</html>
