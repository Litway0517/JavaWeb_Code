<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		<span class="wel_word">图书管理系统</span>

		<%--  静态包含管理界面 --%>
		<%@ include file="/pages/common/manager_menu.jsp"%>

	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<tr>
				<td>时间简史</td>
				<td>20.00</td>
				<td>霍金</td>
				<td>200</td>
				<td>400</td>
				<td><a href="book_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>


<%--			${ requestScope.books }--%>
<%--			这个JSTL标签使用的时候, 一定要导包--%>
			<c:forEach items="${ requestScope.books }" var="book">

				<tr>
					<td>${ book.bookName }</td>
					<td>${ book.bookPrice }</td>
					<td>${ book.bookAuthor }</td>
					<td>${ book.bookSales }</td>
					<td>${ book.bookStock }</td>
					<td><a href="book_edit.jsp">修改</a></td>
					<td><a href="#">删除</a></td>

				</tr>
			</c:forEach>




			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
