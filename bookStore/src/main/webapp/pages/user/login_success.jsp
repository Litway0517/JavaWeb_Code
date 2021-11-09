<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <!--  Base标签, 固定相对路径的跳转结果  -->

    <%--  改为静态包含 --%>
    <%@ include file="/pages/common/header.jsp"%>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">

<%--
    <div>
        <span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
        <a href="order/order.jsp">我的订单</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
--%>

    <%--  jsp界面静态包含  --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>



</div>

<div id="main">

    <h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
</div>
</body>
</html>
