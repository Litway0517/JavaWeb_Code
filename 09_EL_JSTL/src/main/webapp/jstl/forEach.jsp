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
    遍历1-10这种情况 <br>
    java的遍历是 -> for(i=0; i< 10; i++) <br><br>
    forEach中也有相关属性用作控制 <br>
    begin属性 -> 开始 <br>
    end属性 -> 结束 <br>
    var属性 -> 循环的变量(也是正在遍历到的数据) <br>



    <hr>
    forEach输出1-10(放在表格的行中) <br>
    <table border="1" cellspacing="0">
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${ i }行</td>
        </tr>
    </c:forEach>
    </table>





</body>
</html>




