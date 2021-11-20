package com.atguigu.web.servlet.book;

import com.atguigu.pojo.Book;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
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

        try {
            // 读取前端传入得图书参数, 注入到Bean中
            Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

            // 调用Service层(service层还会调用DAO层)保存到数据库
            bookServiceImpl.addBook(book);

            // 添加图书成功之后, 还需要再跳转到图书馆里界面
//            req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);

            /*
                因为, 请求转发算作一次请求. 当我们点击提交的时候, 浏览器会记录下最后一次得请求, 就是manager/bookServlet. 当按下F5时, 还会执行添加图书得动作, 这是一个bug.
                所以改用重定向. 重定向是由resp, 相应报文发送的重定向, 而不是请求报文req

                而响应报文resp在相应的时候, /  会被解析为port部分, 也就是说缺少了ContextPath(). 所以前面要加上, 都是细节, 需要复习.
                重定向跳转的路由是 -> /manager/bookServlet?action=list
            */
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

        } catch (Exception e) {
            e.printStackTrace();
        }


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
        // 将请求的数据注入到Bean中
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        // 调用Service层的update更新方法, 完成业务
        bookServiceImpl.updateBook(book);

        // 重定向到图书的列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

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
        // 获取前端传过来的待删除的图书的 id编号 -> 实际上直接将参数均注入到一个新的Bean中
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        // 调用Service层的删除业务, 删除图书
        bookServiceImpl.deleteBookById(book.getId());

        // 重定向到, 查询数据列表界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

    }


    /**
     * 客户端点击图书的 修改按钮 时, 因为数据不能直接传入到另一个修改界面的jsp上面, 所以点击修改时先通过servlet, 再转发给修改界面回显
     * @param req 请求参数
     * @param resp 回复参数
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 客户端点击修改的时候, 先请求给servlet
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        // 根据前端传过来的book Bean对象, 抽取其中的id, 根据id查询
        Book bookInfo = bookServiceImpl.queryBookById(book.getId());

        // 将数据保存到request域中
        req.setAttribute("bookInfo", bookInfo);

        // 转发给 book_edit.jsp 修改界面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

}
