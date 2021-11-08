package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 上传servlet
 *
 * @author DELL
 * @date 2021/11/07
 */
public class UploadServlet extends HttpServlet {
    /**
     * 做得到
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 做帖子
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("接收到文件了");

        // 这些数据是null, 获取不到
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("photo"));

        ServletInputStream inputStream = request.getInputStream();

        byte[] buf = new byte[10240000];
        int read = inputStream.read(buf);
        System.out.println("前端上传的数据 -> \n" + new String(buf, 0, read));


    }
}





