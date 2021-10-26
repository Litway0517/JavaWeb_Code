package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 打印html servlet
 *
 * @author DELL
 * @date 2021/10/26
 */
public class PrintHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置服务器和客户端的字符集
        resp.setContentType("text/html; charset=UTF-8");

        // 获取输出流
        PrintWriter writer = resp.getWriter();


        /*
            因为使用response回传数据非常麻烦, 况且一个html界面可能有几千行甚至上万行.
            这样写起来就很麻烦, 不容易维护. 而且没有代码提示功能, 效率很低 -> 因此出现了jsp这种方式
         */
        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\n\r\n");
        writer.write("<head>\n\r\n");
        writer.write("    <meta charset=\"UTF-8\">\n\r\n");
        writer.write("    <title>测试页面</title>\n\r\n");
        writer.write("</head>\n\r\n");
        writer.write("<body>\n\r\n");
        writer.write("    <hr>\n\r\n");
        writer.write("    这是测试的html界面\n\r\n");
        writer.write("</body>\n\r\n");
        writer.write("</html>\n\r\n");
        writer.write("\r\n");
        writer.write("\r\n");


    }
}
