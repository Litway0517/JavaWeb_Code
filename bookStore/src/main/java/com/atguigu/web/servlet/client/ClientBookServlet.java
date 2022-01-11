package com.atguigu.web.servlet.client;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端书servlet
 *
 * @author DELL_
 * @date 2022/01/10
 */
public class ClientBookServlet extends BaseServlet {

    private final BookServiceImpl bookServiceImpl = new BookServiceImpl();

    /**
     * 页面
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1- 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        /*
            在这里需要做数据的边界有效性校验, 这里放在service层来实现
         */

        // 2- 调用BookService.page(pageNo, pageSeize): Page对象
        Page<Book> page = bookServiceImpl.page(pageNo, pageSize);

        // 设置url
        page.setUrl("client/bookServlet?action=page");

        // 3- 保存到request域中, 这是前后端交互数据的重要手段
        req.setAttribute("page", page);

        // 4- 请求转发到, web目录下的index将请求转发给了pages下面的index. 但是中间经过servlet, 因此下面更改
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
