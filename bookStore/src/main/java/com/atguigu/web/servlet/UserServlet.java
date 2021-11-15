package com.atguigu.web.servlet;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户servlet
 *
 * @author DELL
 * @date 2021/11/14
 */
public class UserServlet extends BaseServlet {
    /**
     * 一个很基本的思想 ->
     *      所有前端发送过来的数据, 到了后端都需要将其封装成为一个Bean对象.
     *      或者直接理解为, Bean才是编程时, 要着重注意的一个点, 将需要的数据都考虑为一个Bean
     *      每一次操作的基本单位是Bean
     *
     *      一句话, 前后端交互的最基础的数据就是一个Bean, 通过JSON文件格式进行交换
     */

    UserService userService = new UserServiceImpl();


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());



        // 检查用户输入的相关信息是否正确
        User loginUser = userService.login(user);
        if (loginUser == null) {
            /*
                控制台提示一下 -> 信息错误, 请重新登录
                提示这种方式比较low, 用debug
             */

            // 提示错误信息, 并将正确地相关数据回显给前端
            req.setAttribute("msg", "用户名或密码错误! ");
            req.setAttribute("username", user.getUsername());


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

        // 使用封装好的工具类, 获取到前端传入的参数, 并注入到新的user对象中
        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());
        String code = req.getParameter("code");


        // 目前还没有服务器生成验证码 -> 暂时将验证码写成固定的abcde, 且不区分大小写
        if (code.equalsIgnoreCase("abcde")) {
            // 检查用户名是否可用 -> Web不能直接调用DAO层, 而是使用Service层完成的, 因此需要在 '方法体外' 实例化UserService层
            if (userService.existsUsername(user.getUsername())) {
                // 返回true表示不能使用该用户名注册 -> 提醒 + 跳转到注册界面
                System.out.println("用户名 [" + user.getUsername() + "] 已存在! ");

                // 注册失败的时候, 将原来的数据回显到文本框中
                req.setAttribute("msg", "用户名已存在! ");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());

                // 跳到注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
            else {
                // 用户名不存在表中 -> 可用情况 -> 调用UserService表存到表中 -> 在跳转到注册成功界面
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }
        else {
            // 注册失败的时候, 将原来的数据回显到文本框中
            req.setAttribute("msg", "验证码错误! ");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());

            // 验证码错误 -> 跳转到注册界面
            System.out.println("验证码 [" + code + "] 错误");
            // 这里面也验证了, getRequestDispatcher方法是具有跳转页面的功能的
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }




}
