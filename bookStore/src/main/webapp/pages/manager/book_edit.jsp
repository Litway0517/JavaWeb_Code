<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}

	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%--  静态包含管理界面 --%>
			<%@ include file="/pages/common/manager_menu.jsp"%>

		</div>

		<%-- 这里面读取不到数据, 注意. 保存在request域中是不行, 因为, request域仅仅是支持一次请求.  --%>
<%--		<%=--%>
<%--			request.getAttribute("bookInfo")--%>
<%--		%>--%>
<%--		${ requestScope.bookInfo }--%>

		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="action" value="add"/>
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
						<td><input name="bookName" type="text" value="${ requestScope.bookInfo.bookName }" /></td>
						<td><input name="bookPrice" type="text" value="${ requestScope.bookInfo.bookPrice }"/></td>
						<td><input name="bookAuthor" type="text" value="${ requestScope.bookInfo.bookAuthor }"/></td>
						<td><input name="bookSales" type="text" value="${ requestScope.bookInfo.bookSales }"/></td>
						<td><input name="bookStock" type="text" value="${ requestScope.bookInfo.bookStock }"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
			</form>


		</div>

		<%--  静态包含页脚内容 --%>
		<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
