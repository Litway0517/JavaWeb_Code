package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * servlet上下文
 *
 * @author DELL
 * @date 2021/10/17
 */
public class ContextServlet extends HttpServlet {

    /*
        1、获取 web.xml 中配置的上下文参数 context-param
        2、获取当前的工程路径，格式: /工程路径
        3、获取工程部署后在服务器硬盘上的绝对路径
        4、像 Map 一样存取数据

        注意 -> <context-param>
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("context-param参数username的值是 -> " + servletContext.getInitParameter("username"));
        System.out.println("context-param参数password的值是 -> " + servletContext.getInitParameter("password"));

        /*
            getServletContext返回的仅仅是context-param的内容, 并不能获取到其他的servlet程序的配置
            如果能获取到的话, 上面的username本身就是重复的标签, 那么返回的就是servlet的参数对应的值了, 但是并不是
         */
        System.out.println("init-param参数url的值是 -> " + servletContext.getInitParameter("url"));


        // 2、获取当前的工程路径，格式: /工程路径
        System.out.println("获取当前工程的相对路径 -> " + servletContext.getContextPath());

        /*
            获取工程部署后在服务器硬盘上的绝对路径

            /的解释
            /       斜杠被服务器解析地址为: http://ip:port/工程名/     映射到IDEA代码的web目录
            /就会映射到web目录

            注意 -> 这里的getRealPath()方法, 获取的仅仅是相关文件或者相关文件夹的路径, 但是并不是文件的内容
         */
        System.out.println("获取当前工程的决对路径(就是这个工程在服务器电脑上的绝对路径) -> " + servletContext.getRealPath("/"));
        System.out.println("获取当前工程下的css文件夹的路径 -> " + servletContext.getRealPath("/css"));
        System.out.println("获取当前工程下imgs中的图片的路径 -> " + servletContext.getRealPath("/imgs/1.jpg"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
