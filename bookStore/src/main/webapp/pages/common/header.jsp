<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/9
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
//    session.setAttribute("basePath", basePath);
%>


<!--  Base标签, 固定相对路径的跳转结果  -->
<base href=" <%= basePath %>>"/>

<%--这样写也行--%>
<%--<base href="${ sessionScope.basePath }"/>--%>


<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>






<%--
        <%
            String scheme2 = request.getScheme()
                    + "://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/";

            request.setAttribute("scheme2", scheme2);
        %>
        ${ requestScope.scheme2 }
--%>



