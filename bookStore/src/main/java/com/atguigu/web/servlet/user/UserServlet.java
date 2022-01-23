package com.atguigu.web.servlet.user;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.atguigu.web.servlet.base.BaseServlet;
import com.google.gson.Gson;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 用户servlet
 *
 * @author DELL
 * @date 2021/11/14
 */
public class UserServlet extends BaseServlet {

    UserService userServiceImpl = new UserServiceImpl();

    /**
     * 处理前端登录请求
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());



        // 检查用户输入的相关信息是否正确
        User loginUser = userServiceImpl.login(user);
        if (loginUser == null) {
            /*
                控制台提示一下 -> 信息错误, 请重新登录
                提示这种方式比较low, 用debug
             */

            // 提示错误信息, 并将正确地相关数据回显给前端
            req.setAttribute("msg", "用户名或密码错误! ");
            req.setAttribute("username", user.getUsername());


            // 提示之后别忘了停留在登陆界面 -> 不跳转(这点千万别忘了)
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 先将查询到的用户信息保存到session域(因为request域已经不够用了), 记录下用户信息
            req.getSession().setAttribute("user", loginUser);

            // 登陆成功 -> 跳转到登陆成功界面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    /**
     * 登出用户
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws IOException IO异常
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        // 获取session, 并立即销毁
        req.getSession().invalidate();

        // 重定向
        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }


    /**
     * 处理前端注册请求
     *
     * @param req  请求报文
     * @param resp 响应报文
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置字符集
        // 这个设置字符集的API仅仅是设置了 服务器端 使用的字符集, 不用这个, 使用另一个, 一定要在获取响应流之前调用, 否则失效 -> resp.setContentType("text/html; charset=UTF-8");
        // req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 从session域中获取到验证码的内容, 然后保存下来, 并立即删除, 防止下一次再使用(回退网页, 重新提交).
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        // 使用封装好的工具类, 获取到前端传入的参数, 并注入到新的user对象中
        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());
        String code = req.getParameter("code");


        // 目前还没有服务器生成验证码 -> 暂时将验证码写成固定的abcde, 且不区分大小写
        if (token != null && code.equalsIgnoreCase(token)) {
            // 检查用户名是否可用 -> Web不能直接调用DAO层, 而是使用Service层完成的, 因此需要在 '方法体外' 实例化UserService层
            if (userServiceImpl.existsUsername(user.getUsername())) {
                // 返回true表示不能使用该用户名注册 -> 提醒 + 跳转到注册界面
                System.out.println("用户名 [" + user.getUsername() + "] 已存在! ");

                // 注册失败的时候, 将原来的数据回显到文本框中
                req.setAttribute("msg", "用户名已存在! ");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());

                // 跳到注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
            else {
                // 用户名不存在表中 -> 可用情况 -> 调用UserService表存到表中 -> 在跳转到注册成功界面
                userServiceImpl.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }
        else {
            // 注册失败的时候, 将原来的数据回显到文本框中
            req.setAttribute("msg", "验证码错误! ");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());

            // 验证码错误 -> 跳转到注册界面
            System.out.println("验证码 [" + code + "] 错误");
            // 这里面也验证了, getRequestDispatcher方法是具有跳转页面的功能的
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


    /**
     * 检查用户名存在
     *
     * @param req  要求事情
     * @param resp 分别地
     * @throws IOException IO异常
     */
    protected void checkUsernameExist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 获取用户名参数
        String username = req.getParameter("username");

        // 调用userService层检查用户名唯一性
        boolean flag = userServiceImpl.existsUsername(username);

        // 将结果封装成Map对象
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername", flag);

        // 转换为json字符串传送
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);

    }



}
