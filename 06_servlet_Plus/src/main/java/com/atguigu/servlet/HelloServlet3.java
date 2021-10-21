package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 你好servlet3
 *
 * @author DELL
 * @date 2021/10/17
 */
public class HelloServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET -> 这里是继承了HttpServlet这个类, 因为它是已经封装好了一部分, 加快我们的开发");

        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("有执行到这条语句嘛？ -> bug已经修复了 哦耶~~");


        /*
            演示服务器的500响应状态码

            HTTP Status 500 - / by zero
            type Exception report

            message / by zero

            description The server encountered an internal error that prevented it from fulfilling this request.
            exception
            java.lang.ArithmeticException: / by zero
                com.atguigu.servlet.HelloServlet3.doGet(HelloServlet3.java:30)
                javax.servlet.http.HttpServlet.service(HttpServlet.java:622)
                javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
                org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)

            note The full stack trace of the root cause is available in the Apache Tomcat/8.0.50 logs.
         */
        int i = 12 / 0;

        System.out.println("这行代码执行不到, 因为上面出错了, 服务器会有500报错. ");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("POST -> 这里是继承了HttpServlet这个类, 因为它是已经封装好了一部分, 加快我们的开发");
    }
}
