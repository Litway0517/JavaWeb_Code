<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<%-- 先打印一下测试, 然后再用forEach遍历输出 --%>
	<%--${ sessionScope.orders }--%>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
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

			<c:forEach items="${ requestScope.orders }" var="order">
				<tr>
					<td><fmt:formatDate value="${ order.createTime }" pattern="yyyy-MM-dd" /></td>
					<td>${ order.price }</td>
					<td><a href="orderServlet?action=showOrderDetails&orderId=${ order.orderId }">查看详情</a></td>
					<td>
						<%-- 这个test标签的测试, 具体是否大于或小于..., 是放在括号里面的, 不是外面 --%>
						<c:choose>
							<c:when test="${ order.status == 0 }">
								<a href="orderServlet?action=sendOrder&orderId=${ order.orderId }&status=1"><b><span style="color: deeppink">点击发货</span></b></a>
							</c:when>
							<c:when test="${ order.status == 1 }"><b><span style="color: cornflowerblue">已发货</span></b></c:when>
							<c:when test="${ order.status == 2 }"><b><span style="color: green">已签收</span></b></c:when>
							<c:otherwise><b><span style="color: red">未知错误, 请联系管理员</span></b></c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>


		</table>
	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
