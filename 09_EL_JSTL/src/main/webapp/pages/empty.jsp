<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>empty运算</title>
</head>
<body>

    <%
      /*
        以下几种情况为空：
          1、值为 null 值的时候，为空
          2、值为空串的时候，为空
          3、值是 Object 类型数组，长度为零的时候
          4、list 集合，元素个数为零
          5、map 集合，元素个数为零
       */

      // null
      request.setAttribute("emptyNull", null);

      // 空串
      session.setAttribute("emptyString", "");

      // Object数组, 长度为0
      session.setAttribute("emptyArr", new Object[]{});

      // list数组
      List<String> stringList = new ArrayList<String>();
      session.setAttribute("emptyList", stringList);

      List<String> stringList2 = new ArrayList<String>();
      stringList2.add("李狗蛋");
      session.setAttribute("emptyList2", stringList2);

      // map集合
      HashMap<String, String> map = new HashMap<String, String>();
      application.setAttribute("emptyMap", map);

      HashMap<String, String> map2 = new HashMap<String, String>();
      map2.put("key1", "value1");
      application.setAttribute("emptyMap2", map2);



    %>

    EL表达式的empty运算 -> 如果为被判断的对象为null, 那么empty表达式输出true
    <hr>
    ${ empty emptyNull } <br/>
    ${ empty emptyString } <br/>
    ${ empty emptyList } <br/>
    ${ empty emptyArr } <br/>
    ${ empty emptyMap } <br/>


    <br/><br/><br/>
    当list和map中含有元素的时候 -> false
    <hr>
    ${ empty emptyList2 } <br/>
    ${ empty emptyMap2 } <br/>







</body>
</html>
