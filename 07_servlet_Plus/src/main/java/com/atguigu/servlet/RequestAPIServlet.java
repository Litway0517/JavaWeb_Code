package com.atguigu.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求ApiServlet
 *
 * @author DELL
 * @date 2021/10/18
 */
public class RequestAPIServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
            i. getRequestURI() 获取请求的资源路径
            ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
            iii. getRemoteHost() 获取客户端的ip 地址
            iv. getHeader() 获取请求头
            v. getParameter() 获取请求的参数
            vi. getParameterValues() 获取请求的参数（多个值的时候使用）
            vii. getMethod() 获取请求的方式GET 或POST
            viii. setAttribute(key, value); 设置域数据
            ix. getAttribute(key); 获取域数据
            x. getRequestDispatcher() 获取请求转发对象
         */

        // /07_servlet_Plus/requestApiServlet
        System.out.println("获取请求的资源的路径 -> " + req.getRequestURI());

        //  http://localhost:8091/07_servlet_Plus/requestApiServlet
        System.out.println("获取请求的统一资源定位符(绝对路径) -> " + req.getRequestURL());

        /*
            在IDEA中, 使用localhost访问时, 得到的客户端 ip 地址是 -> 127.0.0.1
            在IDEA中, 使用127.0.0.1访问时, 得到的客户端 ip 地址是 -> 127.0.0.1
            在IDEA中, 使用192.168.137.1访问时, 得到的客户端 ip 地址是 -> 192.168.137.1
         */
        System.out.println("获取客户端 ip(localhost) 地址 -> " + req.getRemoteHost());
        System.out.println("获取客户端 ip(127.0.0.1) 地址 -> " + req.getRemoteHost());
        System.out.println("获取客户端 ip(真实ip地址) 地址 -> " + req.getRemoteHost());


        // 07_servlet [local]
        System.out.println("获取请求头中的某个参数的值 -> " + req.getHeader("User-Agent"));

        // GET
        System.out.println("获取客户端请求的方式 -> " + req.getMethod());


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
