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
    标签的作用: set标签可以用来向域中保存数据  <br>
    域的数据需要key和value两个  <br>

    set标签中的属性  <br>
        scope -> 用来设置向哪个域设置数据, 不指明时, 默认scope="page", page域  <br>
            page            表示pageContext域  <br>
            request         表示request域  <br>
            session         表示session域  <br>
            application     表示servletContext域  <br>

        var -> 用来是设置key的值  <br>
        value -> 用来设置key对应的value值  <br>

--%>


    &lt;c:set /&gt;
    标签的作用: set标签可以用来向域中保存数据  <br>
        域的数据需要key和value两个  <br>

    set标签中的属性  <br>
        scope -> 用来设置向哪个域设置数据, 不指明时, 默认scope="page", page域  <br>
            page            表示pageContext域  <br>
            request         表示request域  <br>
            session         表示session域  <br>
            application     表示servletContext域  <br>

        var -> 用来是设置key的值  <br>
        value -> 用来设置key对应的value值  <br>


    <br>
    <h3>这里是测试</h3>
    <hr>

    保存之前 -> ${ requestScope.key }  <br>
    <c:set scope="request" var="key" value="abcValue" />
    保存之后 -> ${ requestScope.key }  <br>

    <br><br>
    <hr>


    <%--
        标签: <c:if ></c:if>  用来做简单判断
            test属性, 用来填写EL表达式, 注意EL表达式需要用双引号引起来
    --%>
    <c:if test="${ 12==12 }">
        <h3>如果test中的内容为真(test需要用EL表达式写出来), 则执行c:if标签中的内容, 即此处的内容.</h3>
        没有if-else语句
    </c:if>

    <c:if test="${ 12!=12 }">
        <h3>如果test中的内容为假, 则此处的内容不会执行.</h3>
    </c:if>


    <br><br>
    <hr>
    <%--
        标签: <c:choose ></c:if> 用来做多路判断
        会从上向下判断条件, 一旦符合条件便会执行相应的代码. 而不会继续向下执行的.

        c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
            1、标签里不能使用 html 注释，要使用 jsp 注释
            2、when 标签的父标签一定要是 choose 标签
    --%>
    <%-- 先保存数据 --%>
    <%
        request.setAttribute("height", 17);
    %>
    <c:choose>
        <c:when test="${ requestScope.height >= 190 }">绿巨人</c:when>
        <c:when test="${ requestScope.height >= 180 }">很高</c:when>
        <c:when test="${ requestScope.height >= 170 }">还可以</c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${ requestScope.height >= 160 }">大于160</c:when>
                <c:when test="${ requestScope.height >= 150 }">大于150</c:when>
                <c:when test="${ requestScope.height >= 140 }">大于140</c:when>
                <c:otherwise>otherwise的情况还想再次判断, 必须先写choose标签才行. 因为when标签上面必须是choose<br>
                    其他小于140的情况</c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>



</body>
</html>



