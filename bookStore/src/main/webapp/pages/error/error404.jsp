<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误提示404</title>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 100px;
			color: deeppink;
		}
		h2 {
			text-align: center;
			margin-top: 50px;
			color: steelblue;
		}
		a {
			text-align: center;
			margin-top: 50px;
			color: red;
		}
	</style>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>




	<div id="main">

		<h1>很抱歉, 您访问的后台程序出现了错误, 程序猿小哥正在为您抢修!</h1>
		<h2>喵! 系统出错~ 请联系管理员(xmw0517@gmail.com)</h2>
		<a href="index.jsp">返回首页</a>


	</div>


	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
