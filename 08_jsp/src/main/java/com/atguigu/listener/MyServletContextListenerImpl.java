package com.atguigu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 我的impl servlet上下文侦听器
 *
 * @author DELL
 * @date 2021/10/31
 */
public class MyServletContextListenerImpl implements ServletContextListener {



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*
            这里面就可以存放一些想要的数据 -> 到了spring再细说
         */
        System.out.println("ServletContext方法被创建了");
    }



    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext方法被销毁了");
    }
}
