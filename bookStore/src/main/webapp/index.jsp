<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%-- 主页的index.jsp只做一件事情, 就是负责请求转发到pages下面的client这个目录下的index.jsp界面下 --%>
<jsp:forward page="client/bookServlet?action=page" />
