<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL关系运算</title>
</head>
<body>

    <h2>EL中的关系运算</h2>
    <hr>
    ${ 12 == 12 } 或 ${ 12 eq 12 } <br/>
    ${ 12 != 12 } 或 ${ 12 ne 12 } <br/>
    ${ 12 > 12 } 或 ${ 12 gt 12 } <br/>
    ${ 12 < 12 } 或 ${ 12 lt 12 } <br/>
    ${ 12 >= 12 } 或 ${ 12 le 12 } <br/>
    ${ 12 <= 12 } 或 ${ 12 ge 12 } <br/>


    <h2>EL中的逻辑运算</h2>
    <hr>
    ${ (1 == 1) && (2 == 2) } 或 ${ (1 == 1) and (2 == 2) } <br/>
    ${ (1 == 2) || (2 == 2) } 或 ${ (1 == 2) or (2 == 2) } <br/>
    ${ ! true } 或 ${ not true } <br/>

    <h2>EL中的算术运算</h2>
    <hr>
    ${ 12 + 12 } <br/>
    ${ 12 - 12 } <br/>
    ${ 12 * 12 } <br/>
    ${ 12 / 12 } 或 ${ 12 div 12 }<br/>
    ${ 18 / 12 } 或 ${ 18 div 12 }<br/>
    ${ 18 % 12 } 或 ${ 18 mod 12 } <br/>


</body>
</html>
