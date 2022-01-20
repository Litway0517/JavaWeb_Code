package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理过滤器
 *
 * @author DELL_
 * @date 2022/01/19
 */
public class AdminFilter implements Filter {


    /**
     * 管理过滤器
     */
    public AdminFilter() {
        System.out.println("1. AdminFilter的构造器方法");
    }

    /**
     * 初始化
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2. AdminFilter的 init 方法");
    }

    /**
     * 做过滤器
     *
     * @param request  请求
     * @param response 响应
     * @param chain    链
     * @throws IOException      IO异常
     * @throws ServletException servlet异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3. AdminFilter的 doFilter() 方法");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();


        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            // return 语句别忘了
            return;
        } else {
            // 让程序继续向下执行 -> 这行语句很重要, 别漏掉了, 否则程序不会继续向下执行.
            chain.doFilter(request, response);
        }
    }

    /**
     * 摧毁
     */
    @Override
    public void destroy() {
        System.out.println("4. AdminFilter的 destroy() 方法");

    }


}
