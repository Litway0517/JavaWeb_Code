package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * servlet1
 *
 * @author DELL
 * @date 2021/10/19
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 携带材料到servlet1(柜台1)
        String username = request.getParameter("username");
        System.out.println("servlet1(柜台1) 检查请求报文有没有携带相关参数(材料) -> " + username);

        // servlet1(柜台1)完成业务了, 需要盖章, 以方便其他柜台检查相关条件
        request.setAttribute("username", "柜台1的章");

        // 报文没有记忆, 都是第一次办理业务, 所以需要询问怎么路由到servlet2(柜台2)继续办理业务
        /*
            请求转发必须以 斜杠/ 打头
                /       表示的是地址为: http://ip:port/工程名/        这回映射到IDEA的web工程目录下
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

        // 问到了路由地址, 接下来就是过去, 注意是调度的具体实例(即getRequestDispatcher)调用forward方法
        requestDispatcher.forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
