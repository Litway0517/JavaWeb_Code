<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点运算和括号运算</title>
</head>
<body>

    <%
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.put("a.a.a", "包含.运算符的value");

        // 保存到域中
        session.setAttribute("map", map);
    %>


    ${ map.key1 } <br/>
    这种情况会找不到域中的内容, 只会输出一个空串 -> ${ map.a.a.a } <br/>
    解决方式, 将key值用单引号或者双引号引起来, 再放入到中括号中[] -> ${ map["a.a.a"] } <br/>


</body>
</html>
