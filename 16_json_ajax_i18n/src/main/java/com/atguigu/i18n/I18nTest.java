package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * i18n测试
 *
 * @author DELL_
 * @date 2022/01/23
 */
public class I18nTest {


    /**
     * 测试区域
     */
    @Test
    public void testLocale() {

        Locale local = Locale.getDefault();
        System.out.println(local);


        // 获取中文, 中文的常量Locale对象
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);


    }


    /**
     * 测试i18n
     */
    @Test
    public void testI18n() {
        Locale us = Locale.US;

        ResourceBundle i18n = ResourceBundle.getBundle("i18n", us);
        System.out.println("username: " + i18n.getString("username"));
        System.out.println("password: " + i18n.getString("password"));


    }


}
