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

        System.out.println("------------doGet--------------");

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
        //        System.out.println("未设置报文的请求体编码 -> 获取的username的值是 -> " + request.getParameter("username"));
        /*
            设置一下, Tomcat接收到的客户端的请求报文, 的请求体的编码 -> 避免出现乱码

            而且, 在此之前不能调用request对象, 否则仍然会出现乱码
            TODO: 也就是说, setCharacterEncoding("")这个API必须在调用getParameter() getParameterValues()等API之前使用,
                    否则setCharacterEncoding("")会失效. 因此,一旦进入doPost方法, 就应该先设置这个API
         */
        request.setCharacterEncoding("UTF-8");

        System.out.println("------------doPost--------------");
        /*
            获取前端表单发送过来的数据

            注意 -> post请求, 加上表单如果出现中文, 就会有乱码情况
         */
        // 需要前端的某个值, 参数就是对应标签的name的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");


        System.out.println("设置了报文的请求体编码 -> 获取的username的值是 -> " + username);
        System.out.println("获取的password的值是 -> " + password);
        System.out.println("获取的hobby的值是 -> " + Arrays.asList(hobbies));

    }
}
