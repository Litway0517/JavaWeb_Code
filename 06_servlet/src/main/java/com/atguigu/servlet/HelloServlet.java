package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;


/**
 * hello servlet
 *
 * @author DELL
 * @date 2021/10/14
 */
public class HelloServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service()方法是专门用来处理客户端的请求的, 并处理后给出响应
     * 简单来说就是, 只要前端有请求, 访问了Servlet -> 那么就执行HelloServlet的service方法
     *
     * @param servletRequest 请求
     * @param servletResponse 回应
     * @throws ServletException 异常显示
     * @throws IOException IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet 被访问了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}






