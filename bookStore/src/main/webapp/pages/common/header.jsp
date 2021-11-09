<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/9
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    String scheme = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + "/"
            + request.getContextPath()
            + "/";

//    session.setAttribute("scheme", scheme);

%>


<!--  Base标签, 固定相对路径的跳转结果  -->
<base href=" <%= scheme %>>"/>

<%--这样写也行--%>
<%--<base href="${ sessionScope.scheme }"/>--%>


<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>




