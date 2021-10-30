<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/30
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp练习二</title>
</head>
<style type="text/css">
    table {
        border: 1px solid blue;
        width: 700px;
        border-collapse: collapse;
    }

    td, th {
        border: 1px solid blue;
    }

</style>
<body>

<%--    创建列表--%>
<%
    ArrayList<Student> studentList = new ArrayList<Student>();
    for (int i = 0; i < 10; i++) {
        int num = i + 1;
        studentList.add(new Student(num, "stu" + num, 18 + num, "phone" + num));

    }

%>


    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
            <% for (Student stu : studentList) { %>
            <tr>
                <td><%=stu.getId()%></td>
                <td><%=stu.getName()%></td>
                <td><%=stu.getAge()%></td>
                <td><%=stu.getPhone()%></td>
                <td>删除 OR 修改</td>
            </tr>

        <% } %>
    </table>


</body>
</html>




