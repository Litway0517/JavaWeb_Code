package com.atguigu.web.servlet.cart;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.servlet.base.BaseServlet;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 购物车servlet
 *
 * @author litway_
 * @date 2022/01/19
 */
public class CartServlet extends BaseServlet {

    /**
     * 书服务impl
     */
    private BookServiceImpl bookServiceImpl = new BookServiceImpl();
    /*
        下面这些方法, 完成业务需求之后, 大部分是重定向到某地址, 而request域不支持重定向, 因此均是使用的session域存储数据.
     */

    /**
     * 增加商品项
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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

        // 保存最后一个添加的图书的名称, 因为首页要使用
        req.getSession().setAttribute("lastName", cartItem.getName());


        // 重定向回原来的地址界面
        resp.sendRedirect(req.getHeader("Referer"));

    }


    /**
     * ajax添加物品
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        // 获取请求参数
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);

        // 根据客户端传过来的图书的id, 到数据库中查询相应的图书的具体信息
        Book book = bookServiceImpl.queryBookById(bookId);

        // 将查询到的信息赋值给CartItem实体类
        CartItem cartItem = new CartItem(book.getId(), book.getBookName(), 1, book.getBookPrice(), book.getBookPrice());

        // 调用加入购物车方法 -> 这里需要判断一次
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        System.out.println(cart);
        // 重定向回首页 -> 这里有问题
        System.out.println("请求地址 : " + req.getHeader("Referer"));

        // 保存最后一个添加的图书的名称, 因为首页要使用
        req.getSession().setAttribute("lastName", cartItem.getName());

        // 返回购物车的总数量, 和最后一个添加的商品名称
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());
        resultMap.put("cartEmpty", false);

        Gson gson = new Gson();
        String resultMapToJson = gson.toJson(resultMap);
        resp.getWriter().write(resultMapToJson);

    }


    /**
     * 删除购物车的商品
     *
     * @param req  请求报文
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


    /**
     * 清楚购物车
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 调用清除购物车的方法
            cart.clear();

            // 重定向
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 更新商品的数量
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取前端参数
        int bookId = WebUtils.parseInt(req.getParameter("id"), 0);
        int bookCount = WebUtils.parseInt(req.getParameter("count"), 1);

        // 获取session域中的cart数据
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //  调用更新数量方法
            cart.updateCount(bookId, bookCount);
            // 重定向
            resp.sendRedirect(req.getHeader("Referer"));

        }


    }



}
