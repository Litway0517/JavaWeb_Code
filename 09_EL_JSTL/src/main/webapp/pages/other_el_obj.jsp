<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/2
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp页面的其他对象</title>
</head>
<body>

    输出前端的参数, 浏览器的地址应该是这样的 -> 127.0.0.1:8080/09_EL_JSTL/pages/other_el_obj.jsp?username=litway&password=litway
    <hr>
    输出用户名参数, username -> ${ param.username } <br>
    输出密码参数, password -> ${ param.password } <br>
    输出用户名参数, username(需要加上那个下标索引) -> ${ paramValues.username[0] } <br>
    输出爱好列表 -> ${ paramValues.hobby[0] } <br>

    <br><br>
    输出header中的内容
    <hr>
    请求头 -> ${ header } <br>
    输出请求头中的[user-agent] -> ${ header.user-agent } (这样就是0, 因为-号的原因, 需要加上单引号)<br>
    输出请求头中的[user-agent] -> ${ header['user-agent'] } (这里是正确的)<br>
    输出请求头中的[Connection] -> ${ header.Connection } <br>

    输出请求头中的[user-agent] -> ${ headerValues['user-agent'][0] } <br>

    <br><br>
    输出cookie中的内容
    <hr>
    {Admin-Token=javax.servlet.http.Cookie@4bb28df9, Idea-f76c3dcb=javax.servlet.http.Cookie@7d599b09, JSESSIONID=javax.servlet.http.Cookie@49cae41} <br>
    JSESSIONID这个值是重要的 -> ${ cookie } <br>
    获取cookie的名称 -> ${ cookie.JSESSIONID.name } <br>
    获取cookie的值 -> ${ cookie.JSESSIONID.value } <br>


    <br><br>
    输出web.xml文件中的context-param内容
    <hr>
    现在还未赋值 -> ${ initParam } <br>
    已经赋值 -> ${ initParam.username } <br>
    这里需要重新部署web服务器才能够生效


</body>
</html>







