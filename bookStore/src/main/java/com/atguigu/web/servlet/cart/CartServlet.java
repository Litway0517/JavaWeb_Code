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

public class CartServlet extends BaseServlet {

    /**
     * 增加商品项
     * @param req 请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookServiceImpl bookServiceImpl = new BookServiceImpl();

        // 获取请求参数
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);

        // 根据客户端传过来的图书的id, 到数据库中查询相应的图书的具体信息
        Book book = bookServiceImpl.queryBookById(bookId);

        // 将查询到的信息赋值给CartItem实体类
        CartItem cartItem = new CartItem(book.getId(), book.getBookName(), 1, book.getBookPrice(), book.getBookPrice());

        // 调用加入购物车方法 -> 这里需要判断一次
        /*
            这个版本是, 将数据存储在session域中的, 因此, 这里的重点是(以后遇到这种情况, 也这样处理):
                - 什么也不做, 首先从域中尝试取出来对象, 即getAttribute("XXX")
                - 然后判断, 取出来的东西究竟是不是空(代码只会帮你到指定的域中取数据, 但是并不会帮你判断! 不要误以为域中有你要的数据)
                    - 是空, 创建一个新的购物车对象, 将相应的商品项加入到购物车
                    - 非空, 说明已经有了购物车对象, 那么就直接加入到购物车就行了. 而不需要重新再创建购物车后将商品放入到购物车.
         */
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        // 重定向回首页 -> 这里有问题
        System.out.println("请求地址 : " + req.getHeader("Referer"));
        // 重定向回原来的地址界面
        resp.sendRedirect(req.getHeader("Referer"));

    }


    /**
     * 删除购物车的商品
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取前端参数, 图书的id编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        // 获取session域中的cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 判断是否为空
        if (cart != null) {
            cart.deleteItem(id);

            // 重定向回到原来的购物车
            resp.sendRedirect(req.getHeader("Referer"));
        }

        System.out.println("请求地址 : " + req.getHeader("Referer"));
        System.out.println(cart);


    }

}
