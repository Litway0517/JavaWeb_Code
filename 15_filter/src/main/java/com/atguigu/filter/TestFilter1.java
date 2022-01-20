package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 测试filter1
 *
 * @author DELL_
 * @date 2022/01/20
 */
public class TestFilter1 implements Filter {


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

        System.out.println("TestFilter1 前置代码");
        System.out.println("TestFilter1的线程名称: " + Thread.currentThread().getName());
        // 前端访问的时候, 记着在地址栏手动带上参数
        System.out.println("TestFilter1中的request域是共享的(因为这是一次请求): " + request.getParameter("username"));

        // 在TestFilter1中存储数据, TestFilter2中也能获取到同样的值
        request.setAttribute("user", "litway");

        /*
            FilterChain.doFilter(req, resp): 这个方法的作用:
                - 执行下一个Filter过滤器(如果有下一个过滤器)
                - 执行目标资源(没有Filter过滤器了)
         */
        chain.doFilter(request, response);


        System.out.println("TestFilter1的线程名称: " + Thread.currentThread().getName());
        System.out.println("TestFilter1 后置代码");

    }

    /**
     * 摧毁
     */
    @Override
    public void destroy() {

    }
}
