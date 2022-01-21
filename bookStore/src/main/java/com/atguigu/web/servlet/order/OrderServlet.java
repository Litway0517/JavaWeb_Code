package com.atguigu.web.servlet.order;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author DELL_
 *
 * @date 2022/01/19
 */
public class OrderServlet extends BaseServlet {

    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    /**
     * 处理前端的结账功能请求
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取购物车cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        /*
            获取userId
            这里当然能够获取到user对象, 因为用户信息在登陆成功的时候, 已经被保存到了session域中, 可以到userServlet程序中查看.
         */
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            /*
                请求转发之后, 一般就不再做任何操作了, 所以这里:
                    - 如果发现了用户没有登陆, 那么就直接转发到登陆界面, 让用户操作. 重点:　一定要有一个return语句.
                      这样下面的代码就不会执行了

                    －　如果用户已经登陆, 那么这个if语句体不执行, 自然就会向下执行. return语句是指就什么事情都不做, 直接返回.
             */
            return;
        }

        // 观察整个 创建订单 流程的执行过程中, 线程的名称
        System.out.println("orderServlet 线程的名称: " + Thread.currentThread().getName());


        Integer userId = loginUser.getId();

        // 调用orderService.createOrder()
        String orderId = orderServiceImpl.createOrder(cart, userId);

        // 保存订单编号到request域中. -> 更新为session域
        // req.setAttribute("orderId", orderId);
        req.getSession().setAttribute("orderId", orderId);

        // 请求转发
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);


        /*
            上面的请求转发, 如果用户在 订单号 界面, 按住F5不断刷新的话, 那么就会一直重复提交购物车界面的表单, 这样数据库就会重复插入
            使用重定向解决, 但是使用重定向, request域的数据就不能够带回到checkout.jsp界面, 因此要将orderId存储在session域中
         */
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 管理员功能 -> 查询所有订单
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 查询所有订单信息
        List<Order> orders = orderServiceImpl.queryAllOrders();

        /*
            保存到request域中 -> 这里面不保存到session域中了, 因为request域能够满足.
            如果保存到session域中, 需要使用重定向. 那么在 订单管理 界面, 刷新的时候就没有了作用, 不能够刷新出来新数据了.
         */
        // req.getSession().setAttribute("orders", orders);
        req.setAttribute("orders", orders);

        // 这里需要重定向回到 订单管理界面, 否则, 当点击 点击发货 按钮时, 页面就直接空了, 需要重定向回去. 再次调用showAllOrders方法
//        resp.sendRedirect(req.getContextPath() + "/pages/manager/order_manager.jsp");
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);

    }


    /**
     * 管理员功能 -> 修改订单状态
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取前端的参数
        int status = WebUtils.parseInt(req.getParameter("status"), 0);
        // 这里直接获取就行, 转换回来的就是String类型, 刚好能够使用
        String orderId = req.getParameter("orderId");


        // 调用orderServiceImpl.changOrderStatus(orderId, status)
        orderServiceImpl.sendOrder(orderId, status);

        // 请求转发 -> 这里如果按F5同样会产生请求重新发起的情况, 因此需要重定向
        // req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);

        // 重定向 -> 注意, 这里重定向回去的是调用showAllOrders方法
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showAllOrders");


    }


    /**
     * 根据用户id, 查询该用户下的所有的订单
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void queryOrdersByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取用户的id
        User loginUser = (User) req.getSession().getAttribute("user");
        // 判断user是否为空, 为空就说明没有登录, 所以跳转登陆界面
        if (loginUser == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }
        // 否则, 已经登陆. 调用orderServiceImpl.queryOrdersByUserId(Integer userId)
        List<Order> orders = orderServiceImpl.queryOrdersByUserId(loginUser.getId());

        // 将信息保存到
        req.setAttribute("orders", orders);

        // 请求转发
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);


    }

    /**
     * 根据订单的编号, 查询该订单号下的详细的订单中的具体内容. 一个购物车就是一个订单, 订单详细内容实际上就是购物车中的每一件商品.
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取订单的id信息
        String orderId = req.getParameter("orderId");

        // 调用orderServiceImpl.queryOrderItemsByOrderId(String orderId): List<OrderItem>
        List<OrderItem> orderItems = orderServiceImpl.queryOrderItemsByOrderId(orderId);

        // 保存数据到request域中
        req.setAttribute("orderItems", orderItems);

        // 请求转发到商品详细展示的界面 -> 这个界面没有, 需要准备一下
        req.getRequestDispatcher("/pages/order/order_details.jsp").forward(req, resp);

    }




}
