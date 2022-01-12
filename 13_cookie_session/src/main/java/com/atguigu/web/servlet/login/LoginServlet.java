package com.atguigu.web.servlet.login;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录servlet
 *
 * @author DELL_
 * @date 2022/01/12
 */
public class LoginServlet extends BaseServlet {

    /**
     * 免用户名登录
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {

            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(60 * 60 * 24);
            /*
                设置cookie的参数, 全部都设置OK了, 再将其addCookie. 别先添加了Cookie然后再设置参数, 那不是胡扯嘛?
             */
            resp.addCookie(usernameCookie);
            // 设置cookie一周有效
            resp.getWriter().write("登陆 成功");
        } else {
            resp.getWriter().write("登陆 失败");

        }


//        Cookie findUsernameCookie = CookieUtils.findCookie("username", req.getCookies());
//        if (findUsernameCookie == null) {
//            // 第一次登录
//
//
//
//            Cookie usernameCookie = new Cookie("username", username);
//            resp.addCookie(usernameCookie);
//
//        } else {
//            // 已经登陆过
//            // 保存查询到的名字为username的cookie的值
//            req.setAttribute("username", findUsernameCookie.getValue());
//            // 请求转发回到login登陆界面
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//
//        }




    }


}
