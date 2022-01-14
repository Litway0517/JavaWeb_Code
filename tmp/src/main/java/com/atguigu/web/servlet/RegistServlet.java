package com.atguigu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("username");
        System.out.println("保存到数据库");

        // 请求转发
//        req.getRequestDispatcher("/ok.jsp").forward(req, resp);

        /*
            第一种情况, 提交请求后按F5刷新浏览器重新提交
                因为使用请求转发时, 如果提交完毕之后, 客户端按F5刷新浏览器, 仍会提交最后一次的请求, 那么就不断的保存数据库.
                所以, 这里使用重定向
            解决办法: 使用重定向
         */

        /*
            第二种情况
                由于网络原因, 用户以为请求失败, 用户重复点击了几次提交
                实际上, 服务器已经插入了很多条记录.
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        resp.sendRedirect(req.getContextPath() + "/ok.jsp");

    }
}
