<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/9
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>



<div>
    <span>欢迎<span class="um_span">${ sessionScope.user.username }</span>
    ┃ 光临尚硅谷书城 ┃ &nbsp;&nbsp;</span>
    <a href="orderServlet?action=queryOrdersByUserId">我的订单</a>&nbsp;&nbsp;
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>




