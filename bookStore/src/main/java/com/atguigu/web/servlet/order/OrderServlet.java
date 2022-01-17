package com.atguigu.web.servlet.order;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    /**
     * 处理前端的结账功能请求
     * @param req 请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doGet(req, resp);
    }
}
