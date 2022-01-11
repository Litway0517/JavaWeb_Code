<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
		<span class="wel_word">网上书城</span>

		<div>
			<a href="pages/user/login.jsp">登录</a> |
			<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
			<a href="pages/cart/cart.jsp">购物车</a>
			<a href="pages/manager/manager.jsp">后台管理</a>
		</div>

	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="" method="get">
					价格：<input id="min" type="text" name="min" value=""> 元 -
						<input id="max" type="text" name="max" value=""> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>


			<%--
				因为下面一直使用pageNo(当前页码), pageTotalCount(总记录数)和pageTotal(总页数)变量,
				索性就把该变量给存储起来, 换个名字, 不然下面每次用到的话名字很长
			--%>
			<c:set scope="request" var="pageNo" value="${ requestScope.page.pageNo }"/>
			<c:set scope="request" var="pageTotalCount" value="${ requestScope.page.pageTotalCount }"/>
			<C:set scope="request" var="pageTotal" value="${ requestScope.page.pageTotal }"/>

			<%-- 这是首页的每一个div, 就是前端看到的每一本图书, 遍历输出 --%>
			<c:forEach items="${ requestScope.page.items }" var="book">
				<%-- Page是分页类, Page类中有一个成员变量items代表的是本页的所有图书相关的数据 --%>
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="<c:url value="${ book.bookImgPath }"/>" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${ book.bookName }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${ book.bookAuthor }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${ book.bookPrice }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${ book.bookSales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${ book.bookStock }</span>
						</div>
						<div class="book_add">
							<button>加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>



		<%-- 将分页的控件添加上去 --%>
		<div id="page_nav">
			<c:if test="${ pageNo > 1 }">
				<a href="client/bookServlet?action=page&pageNo=1">首页</a>&nbsp;
				<a href="client/bookServlet?action=page&pageNo=${ pageNo - 1 }">上一页</a>&nbsp;
			</c:if>

			<%-- TODO: 新需求: 显示 5 个连续的页码，而且当前页码在中间。除了当前页码之外，每个页码都可以点击跳到指定页。 --%>
			<%-- 页码输出的开始: 使用c:choose c:when c:otherwise 多路开关实现. 注意: c:when必须跟在c:choose后面 --%>
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
					<a href="client/bookServlet?action=page&pageNo=${ i }">${i}</a>
				</c:if>
			</c:forEach>



			<c:if test="${ pageNo < pageTotal }">
				<a href="client/bookServlet?action=page&pageNo=${ pageNo + 1 }">下一页</a>&nbsp;&nbsp;
				<a href="client/bookServlet?action=page&pageNo=${ pageTotal }">末页</a>&nbsp;&nbsp;
			</c:if>
			&nbsp;&nbsp;共 ${ pageTotal } 页, ${ pageTotalCount } 条记录&nbsp;&nbsp;
			到第<input value="${ pageNo }" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">
		</div>

	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>
