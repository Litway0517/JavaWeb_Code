package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // S1 -> 首先, 解析客户端的请求头, 获取到客户端想要下载的文件的名称是什么. 但是在这里暂时写成固定的文件
        String downloadName = "Snipaste_2021-11-07_22-46-25.jpg";

        // S2 -> 读取要下载的文件内容, 这里有许多种方式, 可以使用ServletContext对象进行读取
        ServletContext servletContext = getServletContext();
        InputStream resourceFile = servletContext.getResourceAsStream("/file/" + downloadName);

        // S3 -> 客户端请求下载文件, 服务器端读取对应文件, 但是需要项客户端互传该文件的类型 -> 通过servletContext获取
        String mimeType = servletContext.getMimeType("/file/" + downloadName);
        // 为客户端的请求头设置文件类型
        resp.setContentType(mimeType);
        System.out.println("下载的文件类型 -> " + mimeType);


        // S4 -> 判断客户端的浏览器是什么样的
        if (req.getHeader("User-Agent").contains("FireFox")) {
            // 如果是火狐浏览器, 那么就是用Base64编码
            resp.setHeader("Content-Disposition", "attachment;filename==?" +
                    new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "=?");
        } else {
            // 如果是IE或者是Chrome, 就是用URL编码
            resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));
        }

        /*
            1 -> 把读取到的文件流回传给客户端
            2 -> 获取相应的输出流
         */
        ServletOutputStream outputStream = resp.getOutputStream();

        // S5 -> 使用IOUtils讲读取到的文件流赋值给 响应的输出流(outputStream)
        IOUtils.copy(resourceFile, outputStream);

    }
}
