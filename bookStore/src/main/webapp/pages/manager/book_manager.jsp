<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <%--
            因为下面一直使用pageNo(当前页码), pageTotalCount(总记录数)和pageTotal(总页数)变量,
            索性就把该变量给存储起来, 换个名字, 不然下面每次用到的话名字很长
        --%>
        <c:set scope="request" var="pageNo" value="${ requestScope.page.pageNo }"/>
        <c:set scope="request" var="pageTotalCount" value="${ requestScope.page.pageTotalCount }"/>
        <C:set scope="request" var="pageTotal" value="${ requestScope.page.pageTotal }"/>

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
                    <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${ pageTotal }">添加图书</a></td>
                </tr>
            </table>
        </form>

        <%-- 将分页的控件添加上去 --%>

        <div id="page_nav">
            <c:if test="${ pageNo > 1 }">
                <a href="manager/bookServlet?action=page&pageNo=1">首页</a>&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo - 1 }">上一页</a>&nbsp;
            </c:if>
            <%-- 更改原有代码, 页码的显示换成了新的需求, 见PDF文档.
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo - 1 }">${ pageNo - 1 }</a>&nbsp;
                [${ pageNo }]&nbsp;
            --%>
            <%--
                再写a超链接标签的href标签的值时, 无论写多长, 都不能换行, 否则的话请求的地址就会莫名其妙出现 空格, 导致访问异常
            --%>
            <%--<a href="manager/bookServlet?action=page&pageNo=${ pageNo + 1 }">${ pageNo + 1 }</a>&nbsp;--%>

            <%-- TODO: 新需求: 显示 5 个连续的页码，而且当前页码在中间。除了当前页码之外，每个页码都可以点击跳到指定页。 --%>
            <%-- 页码输出的开始 --%>
            <c:choose>
                <%-- 情况1: 如果总的页码数<5, 那么就显示1到最大页码数.  --%>
                <c:when test="${ pageTotal <= 5 }">
                    <c:set var="begin" value="1" />
                    <c:set var="end" value="${ pageTotal }" />
                </c:when>
                <%-- 情况2: 如果总页数>5, 需要进行如下处理. 假设有10页 --%>
                <c:when test="${ pageTotal > 5 }">
                    <%-- 页码数大于5时, 还需要分为三种小情况 --%>
                    <c:choose>
                        <%-- 小情况1: 页码为前面3个的情况: 1, 2, 3, 页码范围为: 1-5 --%>
                        <c:when test="${ pageNo <= 3 }">
                            <c:set var="begin" value="1" />
                            <c:set var="end" value="5" />
                        </c:when>
                        <%-- 小情况2: 当前页码为最后3个: 8, 9, 10 --%>
                        <c:when test="${ pageNo > pageTotal - 3 }">
                            <c:set var="begin" value="${ pageTotal - 4 }" />
                            <c:set var="end" value="${ pageTotal }" />
                        </c:when>
                        <%-- 小情况3: 4, 5, 6, 7, 页码范围是: 当前页码-2 到 当前页码+2 --%>
                        <c:otherwise>
                            <c:set var="begin" value="${pageNo - 2 }" />
                            <c:set var="end" value="${ pageNo + 2 }" />
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <%-- 页码输出的结束 --%>

            <%-- 代码优化: 因为forEach只执行一次, 因此上面我们只需要记录下来begin和end的值即可, 让forEach在下面执行 --%>
                <c:forEach begin="${ begin }" end="${ end }" var="i">
                    <c:if test="${ i == pageNo }"> 【${ i }】 </c:if>
                    <c:if test="${ i != pageNo }">
                        <a href="manager/bookServlet?action=page&pageNo=${ i }">${i}</a>
                    </c:if>
                </c:forEach>



            <c:if test="${ pageNo < pageTotal }">
                <a href="manager/bookServlet?action=page&pageNo=${ pageNo + 1 }">下一页</a>&nbsp;&nbsp;
                <a href="manager/bookServlet?action=page&pageNo=${ pageTotal }">末页</a>&nbsp;&nbsp;
            </c:if>
            &nbsp;&nbsp;共 ${ pageTotal } 页, ${ pageTotalCount } 条记录&nbsp;&nbsp;
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
                let pageTotal = ${ requestScope.page.pageTotal };
                console.log("页码 -> ", inputPageNo);
                console.log("当前地址栏地址 -> ", location.href);

                if ((inputPageNo < 1) || (inputPageNo > pageTotal)) {
                    alert("请输入正确的页码数目! ");
                } else {
                    location.href = "${ pageScope.basePath }manager/bookServlet?action=page&pageNo=" + inputPageNo;
                }
            });
        });
    </script>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
