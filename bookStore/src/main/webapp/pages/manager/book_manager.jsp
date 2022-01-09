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
		<img class="logo_img" alt="" src="static/img/logo.gif" >
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

        <%-- 将分页的控件添加上去 --%>

        <div id="page_nav">
            <%-- 因为下面一直使用pageNo这个变量, 索性就把该变量给存储起来, 换个名字, 不然下面每次用到的话名字很长 --%>
            <c:set scope="page" var="pageNo" value="${ requestScope.page.pageNo }"/>
            <c:if test="${ pageNo > 1 }">
                <a href="manager/bookServlet?action=page&pageNo=1">首页</a>&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo - 1 }">上一页</a>&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo - 1 }">${ pageNo - 1 }</a>&nbsp;
            </c:if>
             [${ pageNo }]&nbsp;
            <%--
                再写a超链接标签的href标签的值时, 无论写多长, 都不能换行, 否则的话请求的地址就会莫名其妙出现 空格
            --%>
            <c:if test="${ pageNo < requestScope.page.pageTotal }">
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo + 1 }">${ pageNo + 1 }</a>&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo + 1 }">下一页</a>&nbsp;&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ requestScope.page.pageTotal }">末页</a>&nbsp;&nbsp;
            </c:if>
            共 ${ requestScope.page.pageTotal } 页, ${ requestScope.page.pageTotalCount } 条记录&nbsp;&nbsp;
            到第<input value="${ pageNo }" name="pn" id="pn_input"/>页
            <input id="searchPageBtn" type="button" value="确定">
        </div>
	</div>

    <%-- 这一小段js脚本是为了服务, 客户端输入任意一页时的跳转 --%>
    <script type="text/javascript">
        // 当页面加载完成这段js才能够相应, 别忘了, 这点很容易出错误, 而且不容易找出
        $(function () {
            // 当点击确定按钮时的操作
            $("#searchPageBtn").click(function () {
                const inputPageNo = $("#pn_input").val();
                console.log("页码 -> ", inputPageNo);
                console.log("当前地址栏地址 -> ", location.href);
                location.href = "http://localhost:8080/bookStore/manager/bookServlet?action=page&pageNo=" + inputPageNo;
            });
        });
    </script>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
