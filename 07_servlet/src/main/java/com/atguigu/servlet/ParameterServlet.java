package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;


/**
 * servlet的参数
 *
 * @author DELL
 * @date 2021/10/19
 */
public class ParameterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            获取请求的参数
         */
        // 传入的参数就是  前端标签的name值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 因为hobby有可能是多个值, 所以使用getParameterValues()方法 -> 这样就可以了
        String[] hobby = request.getParameterValues("hobby");


        System.out.println("获取的username值是 -> " + username);
        System.out.println("获取的password值是 -> " + password);
        System.out.println("获取的hobby值是 -> " + Arrays.asList(hobby));

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
