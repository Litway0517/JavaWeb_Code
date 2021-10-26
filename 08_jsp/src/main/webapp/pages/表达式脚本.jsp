<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/26
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达式脚本测试界面</title>
</head>
<body>


    <br/>
    <hr>
    表达式脚本的格式是：
        <%--<%=表达式%>--%>

    表达式脚本的作用是：的 jsp 页面上输出数据。

    表达式脚本的特点：
    1、所有的表达式脚本都会被翻译到_jspService() 方法中
    2、表达式脚本都会被翻译成为 out.print()输出到页面上
    3、由于表达式脚本翻译的内容都在_jspService() 方法中,所以_jspService()方法中的对象都可以直接使用。
    4、表达式脚本中的表达式不能以分号结束。

    练习：
    1. 输出整型
    2. 输出浮点型
    3. 输出字符串
    4. 输出对象

    <br/>
    <hr>
    1. 输出整型<br/>
    <%=12%>


    <br/><br/>
    <hr>
    2. 输出浮点型<br/>
    <%=39.69%>


    <br/><br/>
    <hr>
    3. 输出字符串<br/>
    <%="我爱中国~"%>



    <br/><br/>
    <hr>
    4. 输出对象<br/>
    需要先定义一个对象, 但是定义需要在 声明脚本 中定义
    <%!
        private Integer i = 89;

    %><br/>
    输出i变量
    <%=i%>


    <br/><br/><br/>
    <hr/>
    这个是表达式脚本.jsp这个jsp页面在执行一次后, Tomcat服务器翻译得到的servlet程序 -> 其中有一个方法_servlet()方法比较重要.
        实际上, _servlet这个方法中的, request和response这两个变量都能够使用
    <br/>
    public void _jspService(final javax.servlet.http.HttpServletRequest request,
    final javax.servlet.http.HttpServletResponse response) throws java.io.IOException,
                                                                  javax.servlet.ServletException
    {...}

    <br/>
    前端访问的地址记得加上参数 ->http://localhost:8093/08_jsp/pages/%E8%A1%A8%E8%BE%BE%E5%BC%8F%E8%84%9A%E6%9C%AC.jsp?username=litway168<br>
    语句不需要加分号, 注意~

    <br/>
    <%=
        request.getParameter("username")
    %>




</body>
</html>
