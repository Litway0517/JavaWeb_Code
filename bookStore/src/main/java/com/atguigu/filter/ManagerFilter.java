package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 先进行参数转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 获取session域, 判断用户是否登录
        Object user = httpServletRequest.getSession().getAttribute("user");

        // 进行判断
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(httpServletRequest, response);
            return;
        } else {
            // 放行
            chain.doFilter(httpServletRequest, response);
        }

    }

    @Override
    public void destroy() {

    }
}
