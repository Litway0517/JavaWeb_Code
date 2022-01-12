package com.atguigu.web.servlet.cookie;

import com.atguigu.util.CookieUtils;
import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 饼干servlet
 *
 * @author DELL_
 * @date 2022/01/12
 */
public class CookieServlet extends BaseServlet {

    /**
     * 创建cookie
     *
     * @param req  请求
     * @param resp 响应
     * @throws IOException      IO异常
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 解决中文乱码
        resp.setContentType("text/html; charset=UTF-8");

        // 1- 创建cookie对象
        Cookie cookie = new Cookie("cookie1", "testCookie1");

        // 2- 服务器发送给客户端, 使用resp报文
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("cookie2", "testCookie2");
        resp.addCookie(cookie1);

        resp.getWriter().write("cookie创建成功");
    }

    /**
     * 服务器端获取客户端请求时传过来的cookie
     *
     * @param req  请求
     * @param resp 响应
     * @throws IOException      IO异常
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 遍历获取所有的cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        // 获取某个指定的cookie的值, 因为没有获取指定的cookie的方法, 所以我们需要自行遍历并判断
        Cookie iWantCookie = CookieUtils.findCookie("cookie2", cookies);
//        for (Cookie cookie1 : cookies) {
//            if ("cookie2".equals(cookie1.getName())) {
//                iWantCookie = cookie1;
//            }
//        }

        if (iWantCookie != null) {
            resp.getWriter().write("找到了指定的Cookie");
        }
    }


    /**
     * 更新cookie
     *
     * @param req  请求
     * @param resp 响应
     * @throws IOException      IO异常
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 新建一个cookie对象, 并且置其name值与待修改的cookie一样. 赋予新的cookie值
        Cookie cookie = new Cookie("cookie2", "newCookieValue");

        // 获取客户端的所有cookies
        Cookie[] cookies = req.getCookies();
        resp.getWriter().write("所有Cookie的值: Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");

        // 先在所有的cookies数组中查找需要更改的馁个cookie
        Cookie findCookie = CookieUtils.findCookie("cookie2", cookies);
        resp.getWriter().write("查询到的cookie, 其原来值: findCookie[" + findCookie.getName() + "=" + findCookie.getValue() + "] <br/>");

        // 传回给客户端, 并输出
        resp.addCookie(cookie);
        resp.getWriter().write("第一种方式修改之后的cookie. cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");


        // 直接对查询到的cookie设置其value值
        Cookie cookie1 = CookieUtils.findCookie("cookie1", cookies);
        // 重新赋值之前别忘了判断 -> 因为有可能浏览器压根不存在待查找的cookie
        if (cookie1 != null) {
            cookie1.setValue("modifyNewCookie");
            resp.getWriter().write("第二种方式修改之后的cookie. cookie[" + cookie1.getName() + "=" + cookie1.getValue() + "] <br/>");
        }
        resp.addCookie(cookie1);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
            设置cookie有三种结果: 以秒为单位
                1- 正数: cookie的最大存活周期, 到了这个时间就销毁(删除)
                2- 负数: 默认为-1, cookie 不会被持久存储, 将在 Web 浏览器退出时删除
                3- 0: 立即删除该cookie
         */
        resp.setContentType("text/html; charset=UTF-8");

        Cookie cookie = new Cookie("default", "defaultCookieValue");
        // 实际上-1, 是默认值, 打开Cookie实体类看成员变量就知道了
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie固定的存储时间, maxAge = -1");

    }






}
