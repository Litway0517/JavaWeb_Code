package com.atguigu.web.servlet;

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






        super.doPost(req, resp);
    }
}
