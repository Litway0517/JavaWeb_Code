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
     * 初始化
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
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
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();


        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            // return 语句别忘了
            return;
        } else {
            // 让程序继续向下执行
            chain.doFilter(request, response);
        }
    }

    /**
     * 摧毁
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
