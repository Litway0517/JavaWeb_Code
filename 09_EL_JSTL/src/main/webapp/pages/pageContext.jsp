<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/2
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <h2>[jsp九大内置对象 + jsp脚本表达式&lt%=%&gt]  使用jsp本身的九大内置对象结合表达式脚本输出数据</h2>
    <hr>
    1. 协议 -> <%=request.getScheme()%>  <br/>
    2. ip地址 -> <%=request.getServerName()%>  <br/>
    3. 服务器端口 -> <%=request.getServerPort()%>  <br/>
    4. 当前工程路径名 -> <%=request.getContextPath()%> <br/>
    5. 请求的方法 -> <%=request.getMethod()%> <br/>
    6. 会话id -> <%=session.getId()%> <br/>


    <h2>[jsp九大内置对象 + EL表达式]  使用pageContext对象结合EL表达式输出数据</h2>
    <hr>
    1. 协议 -> ${ pageContext.request.scheme } <br/>
    2. 服务器ip -> ${ pageContext.request.serverName } <br/>
    3. 服务器端口号 -> ${ pageContext.request.serverPort } <br/>
    4. 当前工程路径 -> ${ pageContext.request.contextPath } <br/>
    5. 获取请求的方法 -> ${ pageContext.request.method } <br/>
    6. 获取远程客户端的ip -> ${ pageContext.request.remoteHost } <br/>
    7. 获取会话的id -> ${ pageContext.session.id } <br/>
    <br/>
    <b>
        <span style="color: red">
            上面写的这两种结果pageContext.request.scheme这些东西, 最后直接是scheme, 实际上就是getScheme(),
            Bean对象的getter/setter方法原理. 和request.getScheme()差不多, 结果是一样的. <br/>
            [jsp九大内置对象+表达式脚本]request.getScheme() = [EL的11个隐含对象+EL表达式]pageContext.request.scheme
        </span>
    </b>



    <%-- 代码脚本, 先在域中存放数据, 然后再获取 --%>
    <%--<%
        // 存数据当然是存在jsp的九大内置对象中的四个域对象中, 而不是存储在EL的域中, EL对象本身是用来使用的而不是用来存储的
        // EL对象是用来访问jsp九大内置对象的
        request.setAttribute("req", "req");
        session.setAttribute("session", "session");
        application.setAttribute("application", "application");
    %>--%>

    <h2>[jsp九大内置对象 + EL表达式]  使用jsp本身的九大内置对象结合EL表达式输出数据</h2>
    <hr>
    1- pageScope.pageContext -> ${ pageScope.pageContext }<br/>
    2- requestScope -> ${ requestScope }<br/>
    3- sessionScope -> ${ sessionScope }<br/>
    4- applicationScope -> ${ applicationScope }<br/>
    5- pageContext.request -> ${ pageContext.request }<br/>
    6- pageContext.request(结果是false) -> ${ empty pageContext.request }<br/>
    7- requestScope -> ${ requestScope }<br/>



    <br/>
    <h2>小测试, 尝试使用EL表达式直接输出jsp的九大内置对象👇</h2>
    <hr>
    <span><b>
        1- EL表达式直接输出jsp的request域(输出为空, 这样获取是不正确的, 因为没有使用EL的11个隐藏对象) -></b> ${ request }
    </span>  <br/>
    <span>
        2- 使用表达式脚本输出request域(能够输出, 因为request本身就是jsp的域, 结合jsp的表达式脚本自然能输出) -> <%=request%>
    </span> <br/>
    <span>
        3- EL表达式需要结合11个隐含对象输出request域, 即requestScope对象(注意: request比requestScope方法多) -> ${ requestScope }
    </span> <br/>
    <span>
        4- EL表达式先使用pageContext获取jsp的九大内置对象中的request再输出, 观察与表达式脚本输出request域的区别 -> ${ pageContext.request } <br/>
        实际上为了方便使用, 我们直接使用requestScope即可, 没必要再绕一遍.
    </span> <br/>
    <span>
        5- EL表达式 + EL的11个隐含对象  效果等同于  jsp九大内置对象 + jsp表达式脚本
    </span>
    <br/>
    <br/>








</body>
</html>
