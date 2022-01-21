package com.atguigu.web.threadlocal;

public class OrderDao {


    public void saveOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("orderDao线程 " + name + "中保存的数据: " + ThreadLocalTest.map.get(name));
    }

}
