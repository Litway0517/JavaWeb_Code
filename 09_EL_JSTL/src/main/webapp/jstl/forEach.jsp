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
            color: black;
            border: 1px solid black;
        }
        td, th{
            border: yellowgreen 1px solid;
            border-collapse: collapse;
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

    <table align="center" border="1">
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



    <br><br><br>
    <hr>
    指定开始位置和结束位置(索引从0开始) -> forEach输出List集合, 集合元素为Student <br>
    <table align="center" cellspacing="0" border="1">
        <%-- 表头部分 --%>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>varStatus信息</th>
            <th>current内容</th>
            <th>索引</th>
            <th>计数</th>
            <th>isFirst</th>
            <th>isLast</th>
            <th>获取begin</th>
            <th>获取end</th>
            <th>获取step</th>
            <th></th>
        </tr>

        <%--
            begin -> 表示开始索引
            end -> 表示结束索引
            items -> 表示数据源, 这里需要用EL表达式, 这个很容易忘记
            var -> 是每次操作的对象
            step -> 这个是每次循环的步长, 默认为1

            status中呦很多有用的属性
                current, index, count, first, last, begin, end, step. 这些都是需要对应到Getter()/Setter()上去的
                注意boolean类型的成员变量对应的是isFrst()二不是getFirst()
        --%>
        <c:forEach begin="2" end="7" step="2" varStatus="status" items="${ requestScope.stuList }" var="item">
        <tr>
            <td>${ item.stuId }</td>
            <td>${ item.username }</td>
            <td>${ item.password }</td>
            <td>${ item.password }</td>
            <td>${ item.phone }</td>
            <td>${ status }</td>
            <td>${ status.current }</td>
            <td>${ status.index }</td>
            <td>${ status.count }</td>
            <td>${ status.first }</td>
            <td>${ status.last }</td>
            <td>${ status.begin }</td>
            <td>${ status.end }</td>
            <td>${ status.step }</td>
        </tr>
        </c:forEach>
        <br>varStatus这个属性挺重要的, 能够获取很多信息. 它属于这个javax.servlet.jsp.jstl.core.LoopTagSupport类<br>

        </table>
<br><br><br><br><br><br>


</body>
</html>




