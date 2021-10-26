<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/10/26
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试界面</title>
</head>
<body>

    <hr>
    这是测试的html界面
    b.jsp界面

    <br/><br/>
    <hr>
    练习：
    1、声明类属性
    2、声明 static 静态代码块
    3、声明类方法
    4、声明内部类

    <br/>
    1、这是声明类属性
    <%!

        private Integer id;
        private String name;
        private static Map<String, Object> map;

    %>

    <br/>
    2、这是声明static静态代码块
    <%!

        static {
            map = new HashMap<String, Object>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }

    %>

    <br/>
    3、声明类方法
    <%!

        public int sum(int... objs) {
            int sum = 0;
            for (int obj : objs) {
                sum += obj;
            }
            return sum;
        }

    %>

    <br/>
    4、声明内部类
    <%!

        public class person {
            private Integer age;
            private String name;
            private String address;
        }

    %>



</body>
</html>






