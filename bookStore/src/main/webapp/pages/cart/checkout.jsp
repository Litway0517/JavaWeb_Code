<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">结算</span>

		<%--  jsp界面静态包含  --%>
		<%@ include file="/pages/common/login_success_menu.jsp" %>

	</div>

	<div id="main">

		<h1>
			<c:if test="${ not empty sessionScope.orderId }">你的订单已结算，订单号为: ${ sessionScope.orderId }</c:if>
			<c:if test="${ empty sessionScope.orderId }">
				<b><span style="color: deeppink">喵! 系统出错~ 请联系管理员(xmw0517@gmail.com)</span></b>
			</c:if>

		</h1>


	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
