package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * response1
 *
 * @author DELL
 * @date 2021/10/20
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("response1 在此一游");

        /*
            第一种重定向方式
                - 先设置本网页的状态 -> 302
                - 然后再对 响应报文 设置响应头中的Location参数, 这个参数的作用就是告诉新的地址为多少
         */
        // 设置本界面的状态 -> 需要重定向
//        response.setStatus(302);

        // 设置location
        /*
            这里面其实符合逻辑, 既然已经重定向了, 那么在告诉浏览器"本地址已经被重定向的时候, 就应该顺带把信息之也发送回去"
         */
//        response.setHeader("Location", "http://localhost:8091/07_servlet_Plus/response2");



        /*
            重定向的第二种方式 -> 响应报文调用sendDirect(path)
         */
        response.sendRedirect("http://localhost:8091/07_servlet_Plus/response2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
