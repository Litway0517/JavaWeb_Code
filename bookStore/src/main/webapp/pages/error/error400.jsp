<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误提示</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>




	<div id="main">

		<h1><b><span style="color: deeppink">很抱歉, 您访问的后台程序出现了错误, 程序猿小哥正在为您抢修!</span></b></h1><br>
		<h1><b><span style="color: powderblue">喵! 系统出错~ 请联系管理员(xmw0517@gmail.com)</span></b></h1>
		<h2><span ><a href="index.jsp" style="align-content: center">返回首页</a></span></h2>


	</div>


	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
