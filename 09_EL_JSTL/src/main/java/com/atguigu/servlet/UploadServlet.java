package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

        /*
            这是之前的测试
        // 这些数据是null, 获取不到
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("photo"));

        ServletInputStream inputStream = request.getInputStream();

        byte[] buf = new byte[10240000];
        int read = inputStream.read(buf);
        System.out.println("前端上传的数据 -> \n" + new String(buf, 0, read));

         */

        // 先判断客户端是不是 分段数据, 只有是分段数据的情况才可以接收并处理
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory的实现类DikFileItemFactory
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建处理前端文件的工具类 -> ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            // 解析客户端上传的多段数据, 得到的是FileItem列表
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);

                // 遍历集合, 判断每一个表单项, 是普通类型, 还是上传的文件
                for (FileItem item : list) {
                    if (item.isFormField()) {
                        // true -> 表示的是普通数据

                        System.out.println("表单项的name值是 -> " + item.getFieldName());
                        // UTF-8是为了解决中文乱码问题
                        System.out.println("表单项的value值是 -> " + item.getString("UTF-8"));

                    } else {
                        // false -> 表示的文件数据
                        System.out.println("表单项的name值是 -> " + item.getFieldName());
                        String fileName = item.getName();
                        System.out.println("表单项的文件名 -> " + fileName);

                        // 结尾的两个反斜线不要忘记写了
                        item.write(new File("F:\\IDEA-Java\\notes\\03-JavaWeb\\others\\" + fileName));


                    }
                }




            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}





