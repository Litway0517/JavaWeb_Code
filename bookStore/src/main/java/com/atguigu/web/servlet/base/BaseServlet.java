package com.atguigu.web.servlet.base;

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

    /*
        客户端出现 405 错误码 -> HTTP method GET is not supported by this URL
        意思是指, BookServlet中没有doGet()方法, 因此就会向其继承的父类寻找doGet()方法, 发现父类也没有, 所以现在新增doGet()方法.
        doGet()方法做的就是doPost()的事情. 直接跳转到doPost()中
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 别忘了设置字符集, 很可能就出现乱码 -> setContentType()方法, 能够将客户端和服务器端一次性都设置成UTF-8类型
        resp.setContentType("text/html; charset=UTF-8");
        doPost(req, resp);
    }

    /**
     * 做帖子
     *
     * @param req  要求的事情
     * @param resp 分别地
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    /*
        bookStore UserServlet程序是继承自BaseServlet的, 当请求从客户端传到userServlet这个路由的时候,
        就会先寻找doPost()这个方法, 如果没找到就回去父类找, 所以就是BaseServlet的doPost了,
        此时已经初始化了UserServlet和BaseServlet程序, 所以能够找到login方法

        其他Servlet继承自BaseServlet的程序, 也是一样的原理
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 前端的两个表单的input的name值都叫做action就行了, 所以传过来那个额都能够接收到
        String action = req.getParameter("action");

        try {
            // 获取反射对象 -> 注意, 这个this就是userServlet对象 并不是现在的BaseServlet对象. 通过反射拿到方法名再掉用!
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            // 暴力反射 -> 避免某些方法是被 [private protected 默认] 这三种权限修饰的, 而导致访问失败
            method.setAccessible(true);
            // 调用方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // 把异常向外面抛, 抛给TransactionFilter过滤器
            throw new RuntimeException(e);
        }

    }






}
