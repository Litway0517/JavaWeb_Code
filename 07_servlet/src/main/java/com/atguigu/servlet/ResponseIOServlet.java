package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 响应IOServlet
 *
 * @author DELL
 * @date 2021/10/20
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter();
//        response.getOutputStream();

        /*
            getWriter()和getOutputStream()两个方法, 每次只能使用一个, 不能同时使用
         */





        PrintWriter writer = response.getWriter();
        writer.write("response content!");

        writer.write("\n");
        writer.write("这次回传中文 -> 我爱中国");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
