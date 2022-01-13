package com.atguigu.web.servlet.session;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {


    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        // 创建和获取session对象
        HttpSession session = request.getSession();

        // 判断这个session是否为新 true -> 表示新创建的   false -> 表示旧的
        boolean isNew = session.isNew();

        // 获取session的唯一标识
        String id = session.getId();

        response.getWriter().write("得到的session, id是: <br/>" + id + "<br/>");
        response.getWriter().write("这个session是否是新创建的: " + isNew);


    }


}
