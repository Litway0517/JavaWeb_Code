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
		第一种方式, 判断请求参数是否包含id -> 是否是添加操作: ${ empty param.id ? "add" : "update"} <br>
		第二种方式, 判断requestScope域中book是否是空, 因为修改图书会经过servlet -> 是否是添加操作: ${ empty requestScope.bookInfo ? "add" : "update"}
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%--  静态包含管理界面 --%>
			<%@ include file="/pages/common/manager_menu.jsp"%>

		</div>

        <%--
            如果, 在更新的时候, 会包含id参数. 而新增图书的时候, 就不会有id参数.
            所以, 可以判断
        --%>

		 <%--
		    这里面读取不到数据, 注意. 保存在request域中是不行, 因为, request域仅仅是支持一次请求.

            <%=
                request.getAttribute("bookInfo")
            %>
            ${ requestScope.bookInfo }
		 --%>


        <%--
            book_edit.jsp界面是用来修改图书的. 两个作用: 从 图书管理界面book_manager.jsp 新增和更改 改均是此界面
            1- 新增时候, 是从book_manager界面直接跳转到此界面的, 不需要经过bookServlet界面
            2- 更改时候, 需要将原来的图书数据带到book_edit.jsp界面

            因此, 还可以通过判断是否经过bookServlet来确定具体是那种操作

        --%>



		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="action" value="${ empty requestScope.bookInfo ? "add" : "update"}"/>
                <%--
                    在这里通过hidden隐藏域将id带到了后端, 实际上就是存储在了request.getParameterMap中了, 所以在注入参数的时候会将id也注入给后端的book的id成员变量
                --%>
				<input type="hidden" name="id" value="${ requestScope.bookInfo.id }"/>
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

						<%--
							form表单中, 点击 [提交] 按钮, 会把整个form标签下面的数据发送给 form标签的action 属性指定的值的目标地址.
							此时, 提交动作会把, input中的隐藏于的值提交给目标地址, 把table中的每一行的值提交给目标地址.
						 --%>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
			</form>


		</div>

		<%--  静态包含页脚内容 --%>
		<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
