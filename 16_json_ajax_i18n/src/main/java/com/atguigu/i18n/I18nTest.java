package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;

public class I18nTest {


    @Test
    public void testLocale() {

        Locale local = Locale.getDefault();
        System.out.println(local);


        // 获取中文, 中文的常量Locale对象
        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);


    }


}
