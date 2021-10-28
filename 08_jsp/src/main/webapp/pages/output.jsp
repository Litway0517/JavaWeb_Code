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
    <br/><br/><br/>
    <h1>out与response输出测试, response输出的次序在out之前. resposne先输出, out后输出</h1>
    <hr>
    <%

        out.write("out输出1 <br/>");
        out.write("out输出2 <br/>");


        response.getWriter().write("response输出1 <br/>");
        response.getWriter().write("response输出2 <br/>");

    %>

    <br/><br/><br/>
    <h1>
        out与response输出测试. 默认是response先输出, out在输出, 但是可以提前对out缓存区进行刷新, 使out先输出. 很乱, 就不要用了
    </h1>
    <hr>
    <%
        /*
            jsp界面中有两个输出的流 -> 两个流有各自的输出缓存区
                out -> out缓存区
                response -> response缓存区

            输出的顺序是这样的:
                out缓存区需要flush一下, 然后数据会加入到response缓存区的末尾.
                因此, 一般来说是先输出response的内容(即使代码顺序是颠倒的), 在输出out的内容.
                如果, out提前进行flush了, 那么在flush这行代码的上面的out的内容, 会被先加入到response缓存区中

            有个小结论 -> 当输出时, 一般都使用out, 因为jsp底层使用的就是out, 而不是response

         */
        out.write("out_new输出1 <br/>");

        // 刷新一次
        out.flush();

        out.write("out_new输出2 <br/>");


        response.getWriter().write("response_new1 <br/>");
        response.getWriter().write("response_new2 <br/>");

    %>

    <br/><br/><br/>
    <h1>out输出的两种方式, write和print输出文本</h1>
    <hr>
    <%
        // 当输出字符串时 -> write和print都没有问题
        out.print("12 <br/>");
        out.write("12 <br/>");

    %>

    <br/><br/><br/>
    <h1>out输出的两种方式, write和print输出数字</h1>
    <hr>
    <%

        /*
            但是, 在输出整型时write会出现问题
                原因是, write的源码中, 当将数据加入到out的缓存区时, 是先将该字符强制转为char类型再加入.
                这就导致了, 有些数字强制转换为acsII时, 不能显示. 所以write(12), 就没有在前端显示出来
         */

        // 深入源码, 浅出结论 -> 以后出书的话都是用out中的print方法, 这样所有数据都能够输出在用户的页面上了
        out.write(12);
        out.print(12);

    %>

</body>
</html>
