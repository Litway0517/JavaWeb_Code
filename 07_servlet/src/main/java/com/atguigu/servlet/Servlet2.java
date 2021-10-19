package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * servlet2
 *
 * @author DELL
 * @date 2021/10/19
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            servlet2(柜台2)获取自己的业务所需要的数据
         */
        String username = request.getParameter("username");
        System.out.println("servlet2(柜台2)检查请求报文是否有携带业务需要的数据 -> " + username);


        // 检查请求是否有servlet1(柜台1)的章 -> 这里是通过域变量来确定的
        Object usernameFlag = request.getAttribute("username");
        System.out.println("再次检查 -> 是否有完成了servlet1的前置业务 -> " + usernameFlag);

        // 当所需材料都完整时, 开始处理servlet2(柜台2)
        System.out.println("servlet2(柜台2)处理自己的业务 ---->>>>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
