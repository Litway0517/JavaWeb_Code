<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/28
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这个是基界面</title>
</head>
<body>

    头部信息  <br/>
    主体信息  <br/>

<%--

    <%@ include file=""%>     这个就是页面静态包含

        她址中第一个斜杠/       表示为http:/ip:port/工程路/晚射到代码的web目录


        静态包含的特点：
            1.静态包含不会翻译被包含sp页面。
            2、静态包含其实是把被包含的jsp页面的代码持贝到包含的位置执行编叫
--%>
    <%@ include file="/include/footer.jsp"%>


<%--
    1- 动态包含, 会把包含的页面也翻译为
    2- 动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
    3-
--%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="bbj" />
        <jsp:param name="pasword" value="root" />
    </jsp:include>



</body>
</html>
