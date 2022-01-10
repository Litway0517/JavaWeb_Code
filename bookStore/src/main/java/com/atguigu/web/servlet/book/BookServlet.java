package com.atguigu.web.servlet.book;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
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
        /*
            中间一段时间挺了没接续看视频, 因为上学期期末考试复习. 这里有一些疑惑, 再写一下.
            1- request这个实例对象, 包含了所有的信息.
                为什么前端的请求就自动的将所有的信息都封装好了? 这是Tomcat的功劳, Tomcat自动将客户端请求封装成一个HttpServletRequest对象, 供我们使用.
            2- 前端的请求封装在了request实例对象中, 我们从中解析出来最重要的需求参数, 然后按照需求获取到数据库中的相关数据后, 查询好.
                按照逻辑, 存储到请求的域中, 即request域, 有时也会存储到pageScope, session, application中. 这几个域的生命周期一个比一个长.
            3- 这样前端就能够使用EL表达式结合11个隐含对象输出到客户端, 达成目的.
         */
        req.setAttribute("books", books);
        // s3 -> 请求转发. 因为请求转发算作一次请求, 所以s2是可行的. 当数据存储好了之后, 不要忘记了转发!
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
        // 前端在添加书籍的时候, 后端处理完成之后需要再跳到最后一页. 先获取pageNo再让它始终+1
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;

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

                而响应报文resp在响应的时候, /  会被解析为port部分, 也就是说缺少了ContextPath(). 所以前面要加上, 都是细节, 需要复习.
                重定向跳转的路由是 -> /manager/bookServlet?action=list

                添加了分页功能之后的路径是 -> /manager/bookServlet?action=page
            */
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
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
        // 修改之后仍要跳转到原来的界面
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        // 将请求的数据注入到Bean中
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        // 调用Service层的update更新方法, 完成业务
        bookServiceImpl.updateBook(book);

        // 重定向到图书的列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

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
        // 分页功能添加之后: 删除图书还需要再跳转到相应的页码
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        // 获取前端传过来的待删除的图书的 id编号 -> 实际上直接将参数均注入到一个新的Bean中
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        // 调用Service层的删除业务, 删除图书
        bookServiceImpl.deleteBookById(book.getId());

        // 重定向到, 查询数据列表界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

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


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1- 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        /*
            在这里需要做数据的边界有效性校验, 这里放在service层来实现
         */

        // 2- 调用BookService.page(pageNo, pageSeize): Page对象
        Page<Book> page = bookServiceImpl.page(pageNo, pageSize);

        // 3- 保存到request域中, 这是前后端交互数据的重要手段
        req.setAttribute("page", page);

        // 4- 请求转发到, pages/book_manage.jsp中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);


    }

}
