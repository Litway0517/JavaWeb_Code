package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

public class JdbcUtilsTest {


    @Test
    public void testGetConnection() {
        System.out.println(JdbcUtils.getConnection());
    }
}
