<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>

    <%--  改为静态包含 --%>
    <%@ include file="/pages/common/header.jsp"%>

</head>
<body>
    <%-- 测试输出 --%>
    <%--${ requestScope.orderItems }--%>

    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <span class="wel_word">购物车</span>

        <%--  jsp界面静态包含  --%>
        <%@ include file="/pages/common/login_success_menu.jsp" %>

    </div>

    <div id="main">
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>订单号</td>
            </tr>

            <%-- 使用forEach输出数据 --%>
            <c:forEach items="${ requestScope.orderItems }" var="orderItem">
                <tr>
                    <td>${ orderItem.name }</td>
                    <td>${ orderItem.count }</td>
                    <td>${ orderItem.price }</td>
                    <td><b><span style="color: red">${ orderItem.totalPrice }</span></b></td>
                    <td>${ orderItem.orderId }</td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <%--  静态包含页脚内容 --%>
    <%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
