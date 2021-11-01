<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/1
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出Bean对象</title>
</head>
<body>

    <%

        Person person = new Person();
        person.setName("我爱中国!");
        person.setAge(22);
        person.setPhones(new String[]{"18631466652", "18699998888", "18753248696"});


        LinkedList<String> cities = new LinkedList<String>();
        cities.add("北京");
        cities.add("上海");
        cities.add("东京");

        person.setCities(cities);

        HashMap<Object, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        person.setMap(map);

        pageContext.setAttribute("per", person);

    %>



    使用EL(Expression Language)输出JavaBean对象
    <hr>
    输出Person -> ${ per } <br/>
    输出Person的name属性 -> ${ per.name } <br/>
    输出Person的cities属性 -> ${ per.cities } <br/>
    输出Person的cities属性中的个别值 -> ${ per.cities[1] } <br/>
    输出Person的phones属性 -> ${ per.phones } <br/>
    输出Person的phones属性中的个别值 -> ${ per.phones[2] } <br/>
    输出Person的phones属性中的个别值 -> ${ per.phones[0] } <br/>
    输出Person的map属性 -> ${ per.map } <br/>
    输出Person的map属性的个别值 -> ${ per.map.key1 } <br/>











</body>
</html>


















