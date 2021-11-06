<%@ page import="java.util.HashMap" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.Collection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/4
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach标签</title>

<%--    添加样式--%>
    <style type="text/css">

        table{
            width: 700px;
            color: red;
            border-collapse: collapse;
        }
        td, th{
            border: yellowgreen 1px;
        }

    </style>

</head>
<body>

    <%--
        <br>
        遍历1-10这种情况 <br>
        java的遍历是 -> for(i=0; i< 10; i++) <br><br>
        forEach中也有相关属性用作控制 <br>
        begin属性 -> 开始 <br>
        end属性 -> 结束 <br>
        var属性 -> 循环的变量(也是正在遍历到的数据) <br>
    --%>


    <br>
    <hr>
    遍历1-10这种情况 <br>
    java的遍历是 -> for(i=0; i< 10; i++) <br><br>
    forEach中也有相关属性用作控制 <br>
    begin属性 -> 开始 <br>
    end属性 -> 结束 <br>
    var属性 -> 循环的变量(也是正在遍历到的数据) <br>


    <br>
    forEach输出1-10(放在表格的行中) <br>
    <table border="1" cellspacing="0">
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${ i }行</td>
        </tr>
    </c:forEach>
    </table>


    <br><br>
    <hr>
    forEach输出字符串数组(放在表格的行中) <br>
    <%--
        Java的增强for输出形式 -> for (Object item : arr)

        forEach的标签
            items -> 用来指明待输出的对象
            var -> 表示当前正在遍历的值, 也是增在操作的数据
    --%>
    <%
        request.setAttribute("arr", new String[]{"18694536421", "18699996666", "18666668888"});
    %>
    <table>
    <c:forEach items="${ requestScope.arr }" var="item">
        <tr>
            <td>${ item }</td>
        </tr>
    </c:forEach>
    </table>


    <br><br>
    <hr>
    forEach输出Java中的Map集合对象 <br>
    <%
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "Regexp1");
        map.put("key2", "Regexp2");
        map.put("key3", "Regexp3");
        request.setAttribute("hashMap", map);
    %>

<%--    这个语句会输出三次, 具体的次数就是数据源hashMap的长度--%>
    <c:forEach items="${ requestScope.hashMap }" var="entry">
        ${ entry } <br>
        只获取key -> ${ entry.key } <br>
        只获取value -> ${ entry.value } <br><br>
    </c:forEach>


    <br><br>
    <hr>
    forEach输出List集合, 集合元素为Student <br>
    <%
        // 存储学生对象的集合
        LinkedList<Student> stuList = new LinkedList<Student>();
        for (int i = 0; i < 10; i++) {
            Integer stuId = 2021 + i * 16;
            String username = "stuNo." + i * 3;
            String password = "stuPassword" + (i * 5 % 3);
            Integer age = 18 + i;
            String phone = "186" + (i * 13 % 3) + (i * 13 % 2) + "521396";
            Student student = new Student(stuId, username, password, age, phone);

            stuList.add(student);
        }
        request.setAttribute("stuList", stuList);
    %>
    <c:forEach items="${ requestScope.stuList }" var="item">
        ${ item.stuId }
        ${ item.username }
        ${ item.password }
        ${ item.age }
        ${ item.phone }
        <br>
    </c:forEach>

    <br><br>
    第二种输出方式 -> <br>

    <table align="center" cellspacing="0" border="1">
        <%-- 表头部分 --%>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>

    <c:forEach items="${ requestScope.stuList }" var="item">
        <tr>
            <td>${ item.stuId }</td>
            <td>${ item.username }</td>
            <td>${ item.password }</td>
            <td>${ item.password }</td>
            <td>${ item.phone }</td>
            <td>删除 / 更新</td>
        </tr>
    </c:forEach>


    </table>




</body>
</html>




