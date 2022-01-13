<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
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
			<%-- 如果已经登陆成功, 那么就显示相应的欢迎字样 --%>
			<c:if  test="${ empty sessionScope.user }">
				<a href="pages/user/login.jsp">登录</a> ┃
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
			</c:if>

			<%-- 如果未登陆成功, 那么就显示登录和注册 --%>
			<c:if test="${ not empty sessionScope.user }">
				<span>欢迎<span class="um_span">${ sessionScope.user.username }</span>
				┃ 光临尚硅谷书城 ┃ &nbsp;&nbsp;</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
			</c:if>
			<a href="pages/cart/cart.jsp">购物车</a>
			<a href="pages/manager/manager.jsp">后台管理</a>
		</div>

	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
                    <%-- 隐藏于用于指明后端反射的方法名字 --%>
                    <input type="hidden" name="action" value="pageByPrice">

                    价格：<input id="min" type="text" name="min" value="${ param.min }"><label for="min"> 元 -</label>
                         <input id="max" type="text" name="max" value="${ param.max }"><label for="max"> 元</label>

                    <input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>


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

        <%-- 静态包含分页控件, 地址由后台进行控制 --%>
        <%@ include file="/pages/common/page_nav.jsp"%>
        <%--
            这是被包含界面的编码格式:
                <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            这是包含界面(即本界面)的contentType格式:
                <%@ page contentType="text/html; charset=UTF-8" %>

            两者因为一个空格的原因, 导致后端报错.
        --%>
    </div>




	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>
