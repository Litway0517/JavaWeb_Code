package com.atguigu.web.servlet.user;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 前端的两个表单的input的name值都叫做action就行了, 所以传过来那个额都能够接收到
        String action = req.getParameter("action");

        if (action.equals("login")) {
            System.out.println("处理登录的需求");
            login(req, resp);


        }
        else if (action.equals("regist")) {
            System.out.println("处理注册的请求");
            regist(req, resp);
        }
    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取前端参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        // 检查用户输入的相关信息是否正确
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            /*
                控制台提示一下 -> 信息错误, 请重新登录
                提示这种方式比较low, 用debug
             */

            // 提示错误信息, 并将正确地相关数据回显给前端
            req.setAttribute("msg", "用户名或密码错误! ");
            req.setAttribute("username", username);


            // 提示之后别忘了停留在登陆界面 -> 不跳转(这点千万别忘了)
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登陆成功 -> 跳转到登陆成功界面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }




    }


    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 设置字符集
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        // 目前还没有服务器生成验证码 -> 暂时将验证码写成固定的abcde, 且不区分大小写
        if (code.equalsIgnoreCase("abcde")) {
            // 检查用户名是否可用 -> Web不能直接调用DAO层, 而是使用Service层完成的, 因此需要在 '方法体外' 实例化UserService层
            if (userService.existsUsername(username)) {
                // 返回true表示不能使用该用户名注册 -> 提醒 + 跳转到注册界面
                System.out.println("用户名 [" + username + "] 已存在! ");

                // 注册失败的时候, 将原来的数据回显到文本框中
                req.setAttribute("msg", "用户名已存在! ");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                // 跳到注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
            else {
                // 用户名不存在表中 -> 可用情况 -> 调用UserService表存到表中 -> 在跳转到注册成功界面
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }
        else {
            // 注册失败的时候, 将原来的数据回显到文本框中
            req.setAttribute("msg", "验证码错误! ");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            // 验证码错误 -> 跳转到注册界面
            System.out.println("验证码 [" + code + "] 错误");
            // 这里面也验证了, getRequestDispatcher方法是具有跳转页面的功能的
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }




}
