<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/3
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl核心标签</title>
</head>
<body>

<%--
    <c:set />
    作用: set标签可以用来向域中保存数据
        域的数据需要key和value两个

    set标签中的属性
        scope -> 用来设置向哪个域设置数据, 不指明时, 默认scope="page", page域
            page            表示pageContext域
            request         表示request域
            session         表示session域
            application     表示servletContext域

        var -> 用来是设置key的值
        value -> 用来设置key对应的value值

--%>


    保存之前 -> ${ requestScope.key }  <br>
    <c:set scope="request" var="key" value="abcValue" />
    保存之后 -> ${ requestScope.key }  <br>

</body>
</html>
