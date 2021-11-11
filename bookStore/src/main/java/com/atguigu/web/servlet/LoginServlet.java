package com.atguigu.web.servlet;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * 登录servlet
 *
 * @author DELL
 * @date 2021/10/25
 */
public class LoginServlet extends HttpServlet {

    // 因为登录操作要涉及到操作数据库, 但是Web层不能直接操作数据库 -> 实例化一个Service层(由Service层调用DAo层)
    private UserServiceImpl userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前端参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // 检查用户输入的相关信息是否正确
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            /*
                控制台提示一下 -> 信息错误, 请重新登录
                提示这种方式比较low, 用debug
             */

            // 提示错误信息, 并将正确地相关数据回显给前端
            request.setAttribute("msg", "用户名或密码错误! ");
            request.setAttribute("username", username);



            // 提示之后别忘了停留在登陆界面 -> 不跳转(这点千万别忘了)
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            // 登陆成功 -> 跳转到登陆成功界面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }



    }
}







