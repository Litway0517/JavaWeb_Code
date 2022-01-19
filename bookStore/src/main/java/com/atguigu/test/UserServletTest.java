package com.atguigu.test;


import org.junit.Test;

import java.lang.reflect.Method;


/**
 * @author litway_
 *
 * @date 2022/01/19
 */
public class UserServletTest {

    @Test
    public void login() {
        System.out.println("login()方法被执行了");
    }

    @Test
    public void regist() {
        System.out.println("regist()方法被执行了");
    }

    @Test
    public void updateUser() {
        System.out.println("updateUser()方法被执行了");
    }

    @Test
    public void updatePassword() {
        System.out.println("updatePassword()方法被执行了");
    }


    @Test
    public void main() {

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
