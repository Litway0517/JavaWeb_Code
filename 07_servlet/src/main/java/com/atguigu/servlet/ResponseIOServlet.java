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


        // 虽然设置了服务器的字符集, 但是客户端的字符集是 -> ISO-8859-1(不支持中文哦~)
//        System.out.println(response.getCharacterEncoding());
        response.setCharacterEncoding("UTF-8");

        // 通过响应头设置浏览器的字符集
        response.setHeader("Content-Type", "text/html; charset=UTF-8");


        /*
            第二种方式, 解决中文乱码的问题
                这种方式, 即设置了服务器的字符集也设置了客户端浏览器的字符集.

                不过, 这个API必须要在  获取流  对象之前使用, 否则无效哦
         */
        response.setContentType("text/html; charset=UTF-8");

        // 查看一下是否设置完成
        System.out.println("客户端端字符集 -> " + response.getCharacterEncoding());




        PrintWriter writer = response.getWriter();
        writer.write("response content!");

        writer.write("\n");
        writer.write("这次回传中文 -> 我爱中国");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
