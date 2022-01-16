<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

	<%-- js事件 --%>
	<script type="text/javascript">
		$(function () {

			// 为 [删除] 按钮绑上单击事件
			$("a.deleteItem").click(function () {
				// 这个return语句, 别忘了, confirm是确认框.
				return confirm("确定要删除 [" + $(this).parent().parent().find("td:first").text() + "] 图书嘛? ")
			});

            // 为 [清除购物车] 按钮增加提醒
            $("a.clearCart").click(function () {
                return confirm("确定要清除购物车嘛? ");
            });

            // 为 [数量输入框] 增加事件
            /*
                blur事件, 是指当焦点离开时的事件, 便触发js. 不容易判断输入框的值, 因此这里换成onchange事件
                change事件, 是指当输入框的数据发生改变时, 才会出发事件, 因此, 只要用户不更改数据是不会由响应的.
             */
            $("input.updateCount").change(function () {
                // 获取图书名称
                var bookName = $(this).parent().parent().parent().find("td:first").text();
                // 获取图书的数量
                var count = this.value;

                // 进行判断
                if ( confirm("你确认要将图书 [" + bookName + "] 的数量修改为 " + count + "嘛? ") ) {
                    // 获取图书的id编号
                    let bookId = $(this).attr("bookId");
                    location.href = "http://localhost:8080/bookStore/cartServlet?action=updateCount&id=" + bookId + "&count=" + count;
                } else {
                    /*
                        这里面有一个this.defaultValue值, 这个值就是原来的数据
                        defaultValues属性是表单项Dom对象的值, 他表示默认的value属性值
                     */
                    this.value = this.defaultValue;
                }





            });

		});
	</script>

</head>
<body>
    <%-- 这里打印一下, 看看内容是什么, 再一点一点取出来回显 --%>
	 <%--${ sessionScope }--%>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>


		<%--  jsp界面静态包含  --%>
		<%@ include file="/pages/common/login_success_menu.jsp" %>

	</div>

	<div id="main">

		<table>
			<%-- 表头部分 --%>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<%-- 购物车为空时, 提醒用户 --%>
			<c:if test="${ empty sessionScope.cart.items }">
				<td colspan="5"><a href="index.jsp">亲, 当前购物车为空! 快跟小伙伴们去浏览商品吧~ </a></td>
			</c:if>

			<%-- 购物车非空, 回显图书 --%>
			<c:forEach items="${ sessionScope.cart.items }" var="cartItem">
				<%-- 使用forEach遍历输出, 遍历之前先判断一下 图书数量 这个参数, 如果是0就不显示 --%>

                <tr>
                    <%-- 这里的items是一个Map对象, 因此需要先取一次value值, value是一个数组, 再从数组中取数据 --%>
                    <td>${ cartItem.value.name }</td>
                    <%--<td>${ cartItem.value.count }</td>--%>

                    <%-- 将商品的数量改成输入框控件, 而不是使用文本显示 --%>
                    <td><label><input class="updateCount" bookId="${ cartItem.value.id }" type="text" name="bookCount" value="${ cartItem.value.count }" style="width: 70px;"></label></td>
                    <td>${ cartItem.value.price }</td>
                    <td>${ cartItem.value.totalPrice }</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${ cartItem.value.id }">删除</a></td>
                </tr>


			</c:forEach>

		</table>

		<%-- 底部的总数量和总价格 以及 结账等信息 --%>
		<c:if test="${ not empty sessionScope.cart.items }">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count"> ${ sessionScope.cart.totalCount } </span>件商品</span>
				<span class="cart_span">总金额<span class="b_price"> ${ sessionScope.cart.totalPrice } </span>元</span>
				<span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>

	</div>

	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
