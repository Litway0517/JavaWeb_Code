package com.atguigu.web.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * 线程本地测试
 *
 * @author DELL_
 * @date 2022/01/21
 */
public class ThreadLocalTest {


//    public static Map<String, Object> map = new Hashtable<String, Object>();

    // ThreadLocal这个类, 后面需要指出泛型. key默认就是线程名称, 这个泛型就是带存储数据的类型
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    // 产生一个随机数
    private static Random random = new Random();


    /**
     * 这是内部类
     */
    public static class Task implements Runnable {

        /**
         * 内部类实现了Runnable接口, 必须重写run方法.
         */
        @Override
        public void run() {

            // 在run方法中, 随机生成一个变量(线程要关联的数据), 然后以当前线程的名称为key, 保存到map中
            Integer i = random.nextInt(1000);

            // 获取当前线程的名称
            String name = Thread.currentThread().getName();
            System.out.println("线程 [" + name + "] 生成的随机数是: " + i);
//            map.put(name, i);
            threadLocal.set(i);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 调用一下
            new OrderService().createOrder();


            // 在线程快要结束的时候, 以当前线程的名称为key, 取数据. 查看是否能够取出
//            Object o = map.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程" + name + "快结束时取出来的关联数据是: " + o);


        }

        /**
         * 这是主方法
         *
         * @param args 传入的参数
         */
        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                new Thread(new Task()).start();

            }


        }


    }






}
