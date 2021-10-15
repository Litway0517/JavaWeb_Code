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

        System.out.println(method);

        /*
            注意, 这个请求的类型使用大写字母表示的, GET而不是get
         */
        if ("GET".equals(method)) {
//            System.out.println("处理客户端get请求");

            doGet();
        } else if ("POST".equals(method)) {
//            System.out.println("处理客户端post请求");

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
