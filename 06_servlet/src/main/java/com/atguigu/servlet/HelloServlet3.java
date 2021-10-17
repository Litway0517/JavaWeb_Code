package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET -> 这里是继承了HttpServlet这个类, 因为它是已经封装好了一部分, 加快我们的开发");

        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("有执行到这条语句嘛？ -> bug已经修复了 哦耶~~");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST -> 这里是继承了HttpServlet这个类, 因为它是已经封装好了一部分, 加快我们的开发");
    }
}
