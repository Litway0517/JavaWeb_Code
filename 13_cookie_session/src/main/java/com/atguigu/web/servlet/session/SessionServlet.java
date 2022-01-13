package com.atguigu.web.servlet.session;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 会话servlet
 *
 * @author DELL_
 * @date 2022/01/13
 */
public class SessionServlet extends BaseServlet {


    /**
     * 创建或获取会话
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException IO异常
     */
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


    /**
     * 设置属性
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置session的属性. Session本身是一个域, 能够存储数据的, 别忘了
        req.getSession().setAttribute("key1", "value1");
        // 提示
        resp.getWriter().write("已经向session中保存了数据");
    }


    /**
     * 得到属性
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取存储在Session域中的key1的数据
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("存储在session域中的key1的数据: " + key1);

    }


    /**
     * 默认生活
     * 默认时长
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取session的最大时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        // 客户端输出
        resp.getWriter().write("session的最大超时时长为: " + maxInactiveInterval + "秒 <br/>");
    }

    /**
     * 设置life3
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void setLife3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("设置session的时长为3秒后超时");
    }


}
