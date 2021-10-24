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

        for (int i = 0; i < 50; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println("第" + i  + "个连接 -> " + connection);

            /*
                使用完之后不关闭, 那么这个链接会被一直占用, 因此要记住需要关闭连接
                (其实, 一旦加了close(), 由于释放速度很快, 中间的间隙很小, 50次获取的链接是同一个emm)
             */


            JDBCUtils.close(connection);

        }
    }

}
