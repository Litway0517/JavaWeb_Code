<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>
    <%-- 这里打印一下, 看看内容是什么, 再一点一点取出来回显 --%>
	${ sessionScope }

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
				<td>操作</td>
			</tr>
			<c:forEach items="${ sessionScope.cart.items }" var="cartItem">
				<tr>
					<%-- 这里的items是一个Map对象, 因此需要先取一次value值, value是一个数组, 再从数组中取数据 --%>
					<td>${ cartItem.value.name }</td>
					<td>${ cartItem.value.count }</td>
					<td>${ cartItem.value.price }</td>
					<td>${ cartItem.value.totalPrice }</td>
					<td><a href="cartServlet?action=deleteItem&id=">删除</a></td>
				</tr>

			</c:forEach>




		</table>

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count"> ${ sessionScope.cart.totalCount } </span>件商品</span>
			<span class="cart_span">总金额<span class="b_price"> ${ sessionScope.cart.totalPrice } </span>元</span>
			<span class="cart_span"><a href="#">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>

	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
