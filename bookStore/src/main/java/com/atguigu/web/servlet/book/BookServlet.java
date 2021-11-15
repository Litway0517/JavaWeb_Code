package com.atguigu.web.servlet.book;

import com.atguigu.pojo.Book;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 书servlet
 *
 * @author DELL
 * @date 2021/11/15
 */
public class BookServlet extends BaseServlet {


    private final BookServiceImpl bookServiceImpl = new BookServiceImpl();

    /**
     * 列表 -> 查询图书数据, 并返回到前端客户
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // s1 -> 通过DAO层, 查询到数据
        List<Book> books = bookServiceImpl.queryBooks();
        // s2 -> 将数据保存到request域中, 别忘了域对象是前后端数据交换的一个重要手段
        req.setAttribute("books", books);
        // s3 -> 请求转发. 因为请求转发算作一次请求, 所以s2是可行的.
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    /**
     * 添加 -> 用户行为, 添加图书
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    /**
     * 更新 -> 更新图书
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    /**
     * 删除 -> 删除图书
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
