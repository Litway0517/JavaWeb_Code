package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



/**
 * 你好servlet2
 *
 * @author DELL
 * @date 2021/10/15
 */
public class HelloServlet2 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        // 1 -> 未向web.xml文件中给servlet2程序配置init-param参数时, 尝试获取参数的值
        /*
            因为HelloServlet2程序对应的xml文件, 并没有init-param标签进行配置相应参数, 及参数额度值, 所以获取不到. 为null

            HelloServlet1程序配置了init-param标签, 仅仅作为为HelloServlet1的配置, 不是共用的
         */
        System.out.println("获取servlet2的参数初始化配置的值 -> " + servletConfig.getInitParameter("username"));

        System.out.println("获取HelloServlet2程序的参数的初始化配置值 -> " + servletConfig.getInitParameter("路由地址"));


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 获取请求方式
        String method = request.getMethod();

        System.out.println("这是 " + method + " 种类的请求");

        /*
            注意, 这个请求的类型使用大写字母表示的, GET而不是get
         */
        if ("GET".equals(method)) {
//            System.out.println("处理客户端get请求");

            // 要做的事情封装到方法
            doGet();
        } else if ("POST".equals(method)) {
//            System.out.println("处理客户端post请求");

            // 要做的事情封装到方法
            doPost();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }


    /**
     * 处理GET类型的请求
     */
    public void doGet() {
        System.out.println("处理客户端GET请求");
        System.out.println("处理客户端GET请求");
        System.out.println("处理客户端GET请求");
    }

    /**
     * 处理POST类型的请求
     */
    public void doPost() {
        System.out.println("处理客户端POST请求");
        System.out.println("处理客户端POST请求");
        System.out.println("处理客户端POST请求");
    }



    @Override
    public void destroy() {

    }
}
