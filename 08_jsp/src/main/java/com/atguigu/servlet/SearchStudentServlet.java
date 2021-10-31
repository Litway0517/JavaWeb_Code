package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 搜索学生servlet
 *
 * @author DELL
 * @date 2021/10/31
 */
public class SearchStudentServlet extends HttpServlet {
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

        /*
            1- 获取前端的参数
            2- 执行sql语句, 查询符合条件的数据
            3- 将查询到的数据保存到request域中
            4- 请求转发到jsp界面中, 由jsp完成输出, 反馈给客户端
         */

        // 1和2都不直接在写了, 直接生成学生数据做模拟
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            studentList.add(new Student(num, "stu" + num, 18 + num, "phone" + num));
        }

        // 3- 保存到request域中
        request.setAttribute("studentList", studentList);


        // 4- 请求转发
        request.getRequestDispatcher("/pages/showStudent.jsp").forward(request, response);
        /*
            jsp请求转发的时候, 会把原来jsp界面的九个内置对象中的 三个内置对象 -> request, response, out传递给了目标界面使用
         */

    }


}
