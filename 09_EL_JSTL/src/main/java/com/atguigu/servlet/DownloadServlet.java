package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // S1 -> 首先, 解析客户端的请求头, 获取到客户端想要下载的文件的名称是什么. 但是在这里暂时写成固定的文件
        String downloadName = "Snipaste_2021-11-07_22-46-25.jpg";

        // S2 -> 读取要下载的文件内容, 这里有许多种方式, 可以使用ServletContext对象进行读取
        ServletContext servletContext = getServletContext();
        InputStream resourceFile = servletContext.getResourceAsStream("/file/" + downloadName);

        // S3 -> 客户端请求下载文件, 服务器端读取对应文件, 但是需要项客户端互传该文件的类型 -> 通过servletContext获取
        String mimeType = servletContext.getMimeType("/file/" + downloadName);
        // 为客户端的请求头设置文件类型
        response.setContentType(mimeType);
        System.out.println("下载的文件类型 -> " + mimeType);

        // S4 -> 告诉客户端, 这个数据收到的时候, 是用于下载的, 而不是直接打开等方式
        /*
            Content-Disposition -> 响应头中的这个参数表示的是, 对于该文件的处置(Disposition)方式
            attachment -> 是附件的意思
            filename -> 是服务器端返回给客户端的文件的名字
         */
        response.setHeader("Content-Disposition", "attachment;filename=" + downloadName);

        /*
            把读取到的文件流回传给客户端
            获取相应的输出流
         */
        ServletOutputStream outputStream = response.getOutputStream();

        // S5 -> 使用IOUtils讲读取到的文件流赋值给 响应的输出流(outputStream)
        IOUtils.copy(resourceFile, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
