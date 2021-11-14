package com.atguigu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 基地servlet
 *
 * @author DELL
 * @date 2021/11/14
 */
public abstract class BaseServlet extends HttpServlet {


    /**
     * 做帖子
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     *//*
        bookStore UserServlet程序是继承自BaseServlet的, 当请求从客户端传到userServlet这个路由的时候,
        就会先寻找doPost()这个方法, 如果没找到就回去父类找, 所以就是BaseServlet的doPost了,
        此时已经初始化了UserServlet和BaseServlet程序, 所以能够找到login方法
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 前端的两个表单的input的name值都叫做action就行了, 所以传过来那个额都能够接收到
        String action = req.getParameter("action");

        try {
            // 获取反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            // 调用方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }






}
