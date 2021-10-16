package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * hello servlet
 *
 * @author DELL
 * @date 2021/10/15
 */
public class HelloServlet implements Servlet {


    public HelloServlet() {
        System.out.println("1 - > 构造器中的方法是最先被执行的");
    }

    /**
     * inti方法只会执行一次
     *
     * @param servletConfig servlet配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("2 -> 构造器体内的方法执行完毕之后, 第二步会执行init代码块中的内容");

        // 1 -> 获取servlet的别名servlet-name
        System.out.println("servlet程序的别名是 -> " + servletConfig.getServletName());

        // 2 -> 获取初始化参数init-param
        System.out.println("初始化username的值是 -> " + servletConfig.getInitParameter("username"));
        System.out.println("初始化url的值是 -> " + servletConfig.getInitParameter("url"));

        // 3 -> 获取servletContext
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest 客户端请求
     * @param servletResponse 服务器回应
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 -> 紧着这第三步执行的是service代码块中的内容" + "HelloServlet中的service被执行了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 -> 最后一步执行的是destroy代码块中的内容(这一步需要关闭服务器才能够看到)");
    }
}
