<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/27
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代码脚本测试界面</title>

</head>
<body>

    <br/><br/>
    <hr>
    练习：
    1. 代码脚本----if 语句
    2. 代码脚本----for 循环语句
    3. 翻译后 java 文件中_jspService 方法内的代码都可以写

    <br/><br/>
    <hr>
    1. 代码脚本----if 语句
    <%
        int i = 12;
        if (i == 12) {
            System.out.println("我爱中国~");
        } else {
            System.out.println("我爱中国ELSE");
        }
    %>


    <br/><br/>
    <hr>
    2. 代码脚本----for 循环语句
    <%
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }
    %>

    <br/><br/>
    <hr>
    3. 翻译后 java 文件中_jspService 方法内的代码都可以写
    <%
        String username = request.getParameter("username");
    %>
    <br/>
    <%=username%>


    <br/><br/><br/>
    <h4>混合几种方式使用</h4>
    <table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
        <tr>
            <td>第 <%=j%> 行</td>
        </tr>
    <%

        }
    %>
    </table>






</body>
</html>















