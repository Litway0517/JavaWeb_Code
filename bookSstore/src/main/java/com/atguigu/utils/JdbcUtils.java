package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource;

    static {
        try {
            // 创建prop对象
            Properties prop = new Properties();
            // 读取配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接池
     *
     * @return 连接源
     */
    public static Connection getConnection() {

        Connection conn = null;

        // 获取一个连接
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接, 放回数据库连接池
     *
     * @param connection 等待被关闭的连接
     */
    public static void close(Connection connection) {
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
