package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

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
            filename -> 是服务器端返回给客户端的文件的名字. 这个文件名字是能够随便更改的
         */
//        response.setHeader("Content-Disposition", "attachment;filename=" + downloadName);
//        response.setHeader("Content-Disposition", "attachment;filename=newFileName.jpg");
        /*
            chrome浏览器, 将文件改成中文名时 -> 会出现乱码. 需要改变编码. URLEncoder.encode("中国.jpg", "UTF-8")
            这个叫做URL编码, 把中文转成16进制

            前端的相应头就成为了 ->
                filename=%E4%B8%AD%E5%9B%BD.jpg
         */
//        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));


        /*
            但是火狐浏览器仍然会报错, 下面的是专门为火狐设置的 -> 中间需要BASE64的编码器
         */
        response.setHeader("Content-Disposition", "attachment;filename==?UTF-8?B?" +
                new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "?=");



        /*
            1 -> 把读取到的文件流回传给客户端
            2 -> 获取相应的输出流
         */
        ServletOutputStream outputStream = response.getOutputStream();

        // S5 -> 使用IOUtils讲读取到的文件流赋值给 响应的输出流(outputStream)
        IOUtils.copy(resourceFile, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
