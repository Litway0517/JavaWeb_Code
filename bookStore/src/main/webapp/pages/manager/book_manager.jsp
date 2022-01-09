<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
    <h3>测试打印</h3>
    <hr>
    ${ param } <br/>
    实例 -> 使用EL表达式输出后端传回的所有图书中的一本图书: ${ requestScope.books[10] }

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

	<script type="text/javascript">
		$(function () {
			// 再给标签加上class属性的时候, 不要有下划线
			$("a.deleteClass").click(function () {
				// 在事件function函数中, 有一个this对象, 他就是用户当前正在操作的对象. 这个this对象, 是当前正在相应的事件的DOM对象

				// confirm函数, 点击确定, 则执行题型.
				return confirm("Are you sure you want to delete this [" + $(this).parent().parent().find("td:first").text() + "] book? ");

				// 点击取消, 则返回false, 组织元素的默认行为, 不提交请求
				// return false;
			});
		});

	</script>

</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		<span class="wel_word">图书管理系统</span>

		<%--  静态包含管理界面 --%>
		<%@ include file="/pages/common/manager_menu.jsp"%>

	</div>

	<div id="main">
        <%--
            更新的时候, 需要先把选中的图书的原来的信息带到book_edit.jsp这个界面中.
            所以, form表单的action属性, 还是 action="manager/bookServlet" . 不需要修改.

            新增图书的时候, 所有信息都需要用户直接输入, 所以不需要带过去数据, 就不需要经过bookServlet这个web类.
            所以 -> <a href="pages/manager/book_edit.jsp?method=add">添加图书</a>
            携带的参数就是method=add

            这样逻辑就不是很清晰. 因为, 本身就是book_manager.jsp界面.
            添加图书 和 修改图书 都是一个界面, 就是book_edit.jsp界面完成的, 那么这个任务就应该由book_edit.jsp界面完成

            但是转回来, 实际上这些界面都需要实现! (体会一下这句话)
        --%>
        <form action="manager/bookServlet" method="post">
            <%--
                form表单中的input标签, 里面的name标签固定为action, 但是其值是变化的, 而后端正是利用这个变化的值,
                来确定客户端传过来的是什么需求, 新增, 添加, 删除, 修改等.
             --%>
            <input type="hidden" name="action" value="${ param.method }">
            <table>
                <tr>
                    <td>名称</td>
                    <td>价格</td>
                    <td>作者</td>
                    <td>销量</td>
                    <td>库存</td>
                    <td colspan="2">操作</td>
                </tr>

                <%-- 原来这本固定的书, 现在注释掉
                &lt;%&ndash; 一个写成固定方式的书 &ndash;%&gt;
                <tr>
                    <td>时间简史</td>
                    <td>20.00</td>
                    <td>霍金</td>
                    <td>200</td>
                    <td>400</td>
                    <td><a href="book_edit.jsp">修改</a></td>
                    <td><a href="#">删除</a></td>
                </tr>
                --%>


                <%-- ${ requestScope.books }--%>
                <%-- 这个JSTL标签使用的时候, 一定要导包--%>
                <%-- 注意删除图书的时候, 需要把图书的ID信息也带上, 否则后端不知道怎么删除图书 --%>
                <c:forEach items="${ requestScope.page.items }" var="book">

                    <tr>
                        <td>${ book.bookName }</td>
                        <td>${ book.bookPrice }</td>
                        <td>${ book.bookAuthor }</td>
                        <td>${ book.bookSales }</td>
                        <td>${ book.bookStock }</td>
                        <td><a href="manager/bookServlet?action=getBook&id=${ book.id }&method=update">修改</a></td>
                        <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${ book.id }">删除</a></td>
                    </tr>
                </c:forEach>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="pages/manager/book_edit.jsp?method=add">添加图书</a></td>
                </tr>
            </table>
        </form>
	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
