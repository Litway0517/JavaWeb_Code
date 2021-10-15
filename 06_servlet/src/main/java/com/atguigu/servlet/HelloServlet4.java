package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * 你好servlet4
 *
 * @author DELL
 * @date 2021/10/15
 */
public class HelloServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("通过自动生成servlet程序, 然后在这里写自己的代码就行了. doGet方法被调用");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("通过自动生成servlet程序, 然后在这里写自己的代码就行了. doPost方法被调用");
    }
}
