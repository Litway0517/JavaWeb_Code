<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/30
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp练习 九九乘法口诀表</title>
</head>

<script type="text/css">

    table{
        width: 700px;
    }

</script>
<body>


<%--  需求 -> 在jsp界面中输出九九乘法口诀表  --%>

<%--  因为输出的时候, 有的列没有对齐, 所以将输出的数据放到表格中  --%>
    <h2 align="center">九九乘法口诀表</h2>
    <hr>
    <table align="center">
        <%  // i控制行, j控制列, 这种方式也可以. 使用表达式脚本也可以
            for (int i = 1; i <= 9; i++) { %>
        <tr>
        <% for (int j = 1; j <= i; j++) { %>
            <td> <%=j + "×" + i + "=" + (i * j)%> </td>

            <% } %>
        </tr>
        <% } %>

    </table>





</body>
</html>






