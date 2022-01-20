package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 测试filter2
 *
 * @author DELL_
 * @date 2022/01/20
 */
public class TestFilter2 implements Filter {


    /**
     * 初始化
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

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

        System.out.println("TestFilter2 前置代码");
        System.out.println("TestFilter2的线程名称: " + Thread.currentThread().getName());
        System.out.println("TestFilter2中的request域是共享的(因为这是一次请求): " + request.getParameter("username"));

        // 获取TestFilter1中的数据
        System.out.println(request.getAttribute("user"));

        chain.doFilter(request, response);


        System.out.println("TestFilter2的线程名称: " + Thread.currentThread().getName());
        System.out.println("TestFilter2 后置代码");
    }

    /**
     * 摧毁
     */
    @Override
    public void destroy() {

    }
}
