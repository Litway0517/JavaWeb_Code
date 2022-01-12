package com.atguigu.web.servlet.login;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录servlet
 *
 * @author DELL_
 * @date 2022/01/12
 */
public class LoginServlet extends BaseServlet {

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 获取前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        


    }


}
