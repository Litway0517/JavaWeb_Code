<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-1-19
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        System.out.println("a.jsp界面被执行了");
        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            // return 语句别忘了
            return;
        }
    %>


    这里是 a.jsp 文件

</body>
</html>
