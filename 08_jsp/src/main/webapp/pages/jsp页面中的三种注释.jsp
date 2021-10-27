<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/27
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp页面的三种注释</title>
</head>
<body>

    <h2>jsp真正的注释</h2>
    <%--  中间可以注释掉html和java代码  --%>
    <br/><br/>

    <h2>jsp页面中的html注释</h2>
    就是原本的html的注释
    <!-- 这个是hmtl的注释 -->
    <br/><br/>


    <h2>jsp页面中的java注释</h2>
    需要在代码脚本中写注释
    <%
        // 这就是java单行注释
        /*
            这就是java多行注释
        */
    %>



</body>
</html>
