package com.atguigu.web.servlet.cart;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CartServlet extends BaseServlet {

    /**
     * 增加商品项
     * @param req 请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        BookServiceImpl bookServiceImpl = new BookServiceImpl();

        // 获取请求参数
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);

        // 根据客户端传过来的图书的id, 到数据库中查询相应的图书的具体信息
        Book book = bookServiceImpl.queryBookById(bookId);

        // 将查询到的信息赋值给CartItem实体类
        CartItem cartItem = new CartItem(book.getId(), book.getBookName(), 1, book.getBookPrice(), book.getBookPrice());

        // 调用加入购物车方法 -> 这里需要判断一次
        Cart cart = new Cart();
        cart.addItem(cartItem);

        // 重定向回首页
        resp.sendRedirect(req.getContextPath());


    }
}
