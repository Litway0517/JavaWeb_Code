package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {


    @Test
    public void testLocale() {

        Locale local = Locale.getDefault();
        System.out.println(local);


        // 获取中文, 中文的常量Locale对象
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);


    }


    @Test
    public void testI18n() {
        Locale us = Locale.US;

        ResourceBundle i18n = ResourceBundle.getBundle("i18n", us);
        System.out.println("username: " + i18n.getString("username"));
        System.out.println("password: " + i18n.getString("password"));


    }


}
