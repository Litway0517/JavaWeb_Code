<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/31
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        // 四个域中都保存了相同的key
        /*
           ${ key }
           输出的时候, 会从最小的域逐步向最大的域查找相关数据. pageContext -> request -> session -> application
         */
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>


    ${ key }

</body>
</html>








