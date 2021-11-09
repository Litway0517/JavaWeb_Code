<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>

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
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">后台管理系统</span>
			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../../index.html">返回商城</a>
			</div>
	</div>

	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
