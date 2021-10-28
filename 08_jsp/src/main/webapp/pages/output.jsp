<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/28
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>output输出测试</title>
</head>
<body>
1
    <%

        out.write("out输出1 <br/>");
        out.write("out输出2 <br/>");


        response.getWriter().write("response输出1 <br/>");
        response.getWriter().write("response输出2 <br/>");

    %>

    <br/><br/>

    <%
        /*
            jsp界面中有两个输出的流 -> 两个流有各自的输出缓存区
                out -> out缓存区
                response -> response缓存区

            输出的顺序是这样的:
                out缓存区需要flush一下, 然后数据会加入到response缓存区的末尾.
                因此, 一般来说是先输出response的内容(即使代码顺序是颠倒的), 在输出out的内容.
                如果, out提前进行flush了, 那么在flush这行代码的上面的out的内容, 会被先加入到response缓存区中

         */
        out.write("out_new输出1 <br/>");

        // 刷新一次
        out.flush();

        out.write("out_new输出2 <br/>");


        response.getWriter().write("response_new1 <br/>");
        response.getWriter().write("response_new2 <br/>");

    %>

</body>
</html>
