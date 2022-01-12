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

        // 增加cookie
        Cookie cookie1 = new Cookie("cookie2", "testCookie2");
        resp.addCookie(cookie1);

        // 增加cookie -> 测试删除方法
        Cookie cookieDeleteNow = new Cookie("cookieDeleteNow", "testDeleteFunction");
        resp.addCookie(cookieDeleteNow);

        // 增加cookie -> 设置cookie的生命周期为一个小时(实际上, 一些网站会将时间设置为二十分钟左右, 或者十几分钟, 不会那么长)
        Cookie setCookieLife = new Cookie("setCookieLife", "OneHourCookie");
        resp.addCookie(setCookieLife);

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


    /**
     * 设置cookie的值为-1, 表示关闭浏览器则删除. 默认值其实就是-1
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
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

    /**
     * 设置maxAge, 立即删除该cookie. 0表示零秒, 自然就表示删除
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Cookie cookieDeleteNow = CookieUtils.findCookie("cookieDeleteNow", req.getCookies());
        // 别忘记了判断非空
        if (cookieDeleteNow != null) {
            cookieDeleteNow.setMaxAge(0);
            resp.addCookie(cookieDeleteNow);
            resp.getWriter().write("测试删除方法, 设置cookie的maxAge为0, 表示立即删除");
        }
    }

    /**
     * 设置一个cookie的生存周期
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void setLifeTime(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        Cookie setCookieLife = CookieUtils.findCookie("setCookieLife", req.getCookies());
        if (setCookieLife != null) {
            setCookieLife.setMaxAge(60 * 60);
            resp.addCookie(setCookieLife);
            resp.getWriter().write("设置cookie的存活时间为 1 小时. 3600秒. 时区格式为格林时间");
        }
    }

    /**
     * 为cookie设置path路径, cookie的成员变量的path路径是与浏览器的请求路径相匹配的, 如果不匹配那么本次请求就不会将相应的cookie发送到服务器
     *      CookieA     path=/工程路径
     *      CookieB     path=/工程路径/abc
     *
     *      请求地址1 -> http://ip:port/工程路径
     *          CookieA会发送给url1
     *          CookieB不会发送给url2
     *
     *      http://ip:port/工程路径/abc.html
     *          CookieA会发送给url1
     *          CookieB会发送给url2
     *
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html; charset=UTF-8");

        Cookie path = new Cookie("path", "path");
        path.setPath(req.getContextPath() + "/abc");
        resp.addCookie(path);
        resp.getWriter().write("设置带有path路径的cookie");

    }






}
