package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * 上下文servlet2
 *
 * @author DELL
 * @date 2021/10/18
 */
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 直接获取servletContext对象
        ServletContext servletContext = getServletContext();

        // 未设置值的时候, 返回null
        System.out.println("设置值之前: ContextServlet1 中获取域值数据key1的值 -> " + servletContext.getAttribute("key1"));
        servletContext.setAttribute("key1", "value1");

        System.out.println("ContextServlet1 中获取域值数据key1的值 -> " + servletContext.getAttribute("key1"));
        System.out.println("ContextServlet1 中获取域值数据key1的值 -> " + servletContext.getAttribute("key1"));
        System.out.println("ContextServlet1 中获取域值数据key1的值 -> " + servletContext.getAttribute("key1"));
    }

}
