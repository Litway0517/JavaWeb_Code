package com.atguigu.test;


import java.lang.reflect.Method;


public class UserServletTest {


    public void login() {
        System.out.println("login()方法被执行了");
    }

    public void regist() {
        System.out.println("regist()方法被执行了");
    }

    public void updateUser() {
        System.out.println("updateUser()方法被执行了");
    }

    public void updatePassword() {
        System.out.println("updatePassword()方法被执行了");
    }


    public static void main(String[] args) {

        String action = "updateUser";

        try {
            // 通过反射获取到对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

            // 调用方法
            Object invoke = method.invoke(new UserServletTest());
            System.out.println(invoke);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
