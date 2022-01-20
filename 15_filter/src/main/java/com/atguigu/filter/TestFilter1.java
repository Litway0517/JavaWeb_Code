package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter1 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("TestFilter1 前置代码");

        doFilter(request, response, chain);

        System.out.println("TestFilter1 后置代码");
    }

    @Override
    public void destroy() {

    }
}
