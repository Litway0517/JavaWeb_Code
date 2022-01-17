<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>
	${ sessionScope.orders }

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		<span class="wel_word">订单管理系统</span>

		<%--  静态包含管理界面 --%>
		<%@ include file="/pages/common/manager_menu.jsp"%>

	</div>

	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>

			<c:forEach items="${ sessionScope.order }" var="order">

			</c:forEach>

			<tr>
				<td>2015.04.23</td>
				<td>90.00</td>
				<td><a href="#">查看详情</a></td>
				<td><a href="#">点击发货</a></td>
			</tr>

			<tr>
				<td>2015.04.20</td>
				<td>20.00</td>
				<td><a href="#">查看详情</a></td>
				<td>已发货</td>
			</tr>

		</table>
	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
