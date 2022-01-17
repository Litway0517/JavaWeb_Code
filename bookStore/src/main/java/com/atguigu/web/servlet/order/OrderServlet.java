package com.atguigu.web.servlet.order;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    /**
     * 处理前端的结账功能请求
     * @param req 请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取购物车cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        // 获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            /*
                请求转发之后, 一般就不再做任何操作了, 所以这里:
                    - 如果发现了用户没有登陆, 那么就直接转发到登陆界面, 让用户操作. 重点:　一定要有一个return语句.
                      这样下面的代码就不会执行了

                    －　如果用户已经登陆, 那么这个if语句体不执行, 自然就会向下执行.
             */
            return;
        }
        Integer userId = loginUser.getId();

        // 调用orderService.createOrder()
        String orderId = orderServiceImpl.createOrder(cart, userId);

        // 保存订单编号到request域中
        req.setAttribute("orderId", orderId);

        // 请求转发:
        req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req, resp);



    }
}
