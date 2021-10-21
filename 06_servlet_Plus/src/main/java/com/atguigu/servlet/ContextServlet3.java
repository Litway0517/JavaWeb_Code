package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 上下文servlet3
 *
 * @author DELL
 * @date 2021/10/18
 */
public class ContextServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            因为web工程的context-param配置只有一份, 一个web工程一份.
            所以, 当我们运行了ContextServlet2程序后, context-param就有了初始值, 那么在ContextServlet3中也能访问到
         */
        ServletContext servletContext = getServletContext();
        System.out.println("在ContextServlet3中获取域数据 key1 参数的值 -> " + servletContext.getAttribute("key1"));
        System.out.println("在ContextServlet3中获取域数据 key1 参数的值 -> " + servletContext.getAttribute("key1"));


        /*
            如果一开始就访问contextServlet3网址, key1的值为null. 但是当访问过contextServlet2之后再访问contextServlet3时,
                key1就会有值. 因为在contextServlet2中被赋值过了.
         */
    }


}
