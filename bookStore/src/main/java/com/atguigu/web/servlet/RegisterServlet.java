package com.atguigu.web.servlet;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 注册servlet
 *
 * @author DELL
 * @date 2021/10/24
 */
public class RegisterServlet extends HttpServlet {

    // 实例化Service层 -> 供下面的web层调用
    private UserServiceImpl userService = new UserServiceImpl();


    /**
     * 做得到
     *
     * @param req  客户端请求
     * @param resp 服务器回应
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    /**
     * 做帖子
     *
     * @param req  客户端请求
     * @param resp 服务器回应
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                // 跳到注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 用户名不存在表中 -> 可用情况 -> 调用UserService表存到表中 -> 在跳转到注册成功界面
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 验证码错误 -> 跳转到注册界面
            System.out.println("验证码 [" + code + "] 错误");
            // 这里面也验证了, getRequestDispatcher方法是具有跳转页面的功能的
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

        }
    }
}
