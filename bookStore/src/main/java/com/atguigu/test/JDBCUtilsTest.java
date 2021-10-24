package com.atguigu.test;


import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilsTest {

    @Test
    public void testJDBCUtils() throws Exception {

        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);

        JDBCUtils.close(conn);
    }

}
