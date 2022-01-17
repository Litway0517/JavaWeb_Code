<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>

<div>
<%--    <a href="pages/manager/book_manager.jsp">图书管理</a>--%>
    <%--
        因为客户端在访问的时候需要通过 BookServlet 跳转到图书管理界面, 这样才能获得数据, 否则, 直接用jsp访问拿不到数据
        所以, 这里面的href标签改为 -> manager/bookServlet?action=list

        bookServlet 这个是后台的servlet程序, 没啥好说的.
        ? 后面表示本次请求携带的参数
        action=list 表示到BookServlet之后会即刻调用list方法
            action是我们在BaseServlet反射时的一个入口参数, 很重要. 不过前端传过来action的方式有很多, 比如form表单的action,
            各种input的action, 还有这里的直接在href上加?加参数

        这里面细节有点多
    --%>

<%--    <a href="manager/bookServlet?action=list">图书管理</a>--%>

    <%--
        上面一行是以前我们没有分页的时候的写法, 当点击 [图书管理] 按钮时, 即执行BookServlet的list方法, 查询所有的图书.
        而, 现在我们需要分页, 那么当点击 [图书管理] 按钮时, 应当先执行page分页方法, 故action动作改成page
     --%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="orderServlet?action=showAllOrders">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>

