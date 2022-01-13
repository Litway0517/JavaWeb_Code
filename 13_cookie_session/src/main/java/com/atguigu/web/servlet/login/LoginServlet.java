package com.atguigu.web.servlet.login;

import com.atguigu.web.servlet.base.BaseServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录servlet
 *
 * @author DELL_
 * @date 2022/01/12
 */
public class LoginServlet extends BaseServlet {

    /**
     * 免用户名登录
     * @param req 请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        /*
            获取请求的参数, 调用service层判断 username 和 password 是否匹配:
                是   登陆成功. 保存起来用户名, 用户名存到cookie中, 并设置这个cookie的生命周期, 并返回给客户端. 这样浏览器会把cookie存起来.
                        实际上存起来应该是以文件的方式(查过资料了: IE是存储在文件中的, 纯txt文件. FireFox和Chrome是存储在SQLite中的).
                        因为cookie是存储在文件中的, 浏览器即使关闭了, 下次重新打开浏览器, 浏览器会自动加载数据库/文件中的一由cookie,
                        这样, 原本保存的 cookie=[username=XXX], 就能够加载到前端了, 达到面用户名登录的效果. 这个功能是有用的, 比如,
                        网易163的邮箱登录的时候, 会包含邮箱地址. (密码当然没有)
                不是  自行输入账户密码登录

            主要是没有理解cookie的原理.
            另外EL表达式中有一个隐含对象, cookie, 和req.getCookies()得到的结果一样, 就是获取本网站下所有的cookie.
         */

        // 获取前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {

            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(60 * 60 * 24);
            /*
                设置cookie的参数, 全部都设置OK了, 再将其addCookie. 别先添加了Cookie然后再设置参数, 那不是胡扯嘛?
             */
            resp.addCookie(usernameCookie);
            // 设置cookie一周有效
            resp.getWriter().write("登陆 成功");
        } else {
            resp.getWriter().write("登陆 失败");

        }

    }


}
