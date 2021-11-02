<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope域中的对象输出</title>
</head>
<body>


    <%
        // 这里是给各个域设置值, 而调用的时候是, pageScope, requestScope, sessionScope, applicationScope
        pageContext.setAttribute("key1", "pageContext1");
        pageContext.setAttribute("key2", "pageContext2");
        request.setAttribute("key2", "request");
        session.setAttribute("key2", "session");
        application.setAttribute("key2", "application");
    %>

    <hr>
    当不指明哪个域中的key1时, 从小向大的方向查找 -> 此处输出pageContext2 ->  ${ key2 } <br/>
    指定输出application域中的键key1的值 -> ${ applicationScope.key2 } <br/>
    request用requestScope输出 <br/>
    session用sessionScope输出 <br/>
    application用applicationScope输出 <br/>


</body>
</html>
