package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * forwardc
 *
 * @author DELL
 * @date 2021/10/19
 */
public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            经过ForwardC程序跳转到界面c
         */

        // 获取路由地址 -> 记住是以斜杠/ 打头
        /*
            这个requestDispatcher.forward方法, 不光能够将请求转发到目的地址就是getRequestDispatcher中的地址,
                还能加载路径中的资源
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/test/dispatcher/c.html");
        // forward
        System.out.println(requestDispatcher);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
