package com.atguigu.web.threadlocal;

public class OrderService {

    public void createOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("orderService线程 [" + name + "] 中保存的数据: " + ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }



}
