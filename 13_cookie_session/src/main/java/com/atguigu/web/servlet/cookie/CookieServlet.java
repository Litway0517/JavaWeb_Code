package com.atguigu.web.servlet.cookie;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    /**
     * 创建cookie
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        resp.setContentType("text/html; charset=UTF-8");

        // 1- 创建cookie对象
        Cookie cookie = new Cookie("cookie1", "testCookie1");

        // 2- 服务器发送给客户端, 使用resp报文
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("cookie2", "testCookie2");
        resp.addCookie(cookie1);

        resp.getWriter().write("cookie创建成功");
    }

    /**
     * 创建cookie
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }



    }


}
