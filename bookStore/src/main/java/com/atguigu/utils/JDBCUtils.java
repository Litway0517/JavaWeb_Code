package com.atguigu.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBCUtils
 *
 * @author DELL
 * @date 2021/10/10
 */


/*
    JDBC工具类, 可以直接使用这里面的方法获取连接, 而不需要再重写代码
 */
public class JDBCUtils {

    /*
        因为下面的静态方法, static初始化方法, 需要用到, dataSource这个变量, 而静态方法只能调用静态的对象.
        因此, dataSource需要用static修饰

     */
    // 定义一个类的静态变量 -> 数据池(一个大的池子, 能够从池子中拿出来连接)
    private static DataSource dataSource;

    // 创建一个ThreadLocal对象 用来存储连接
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    /*
        static代码块, 是当类加载完成的时候, 仅仅执行一次, 这样就只会有一个dataSource, 也就是只有一个数据池
        static代码块执行的目的就是为了创建一个数据池, 并赋值给外面的静态dataSource变量
     */
    static {
        try {
            // 创建prop对象
            Properties prop = new Properties();
            // 读取配置文件
            /*
                这里面踩了一个坑， 踩了一天，
                因为， 不同的加载器的路径是不一样的。 反正挺乱的， 需要加强一下。
                最终properties文件是放在resources下面才解决的bug

                TODO: 这里面还要说一下, 因为上次使用JDBCUtils.class加载配置文件的时候, 出了Bug, 后来把jdbc.properties放在了resource目录下解决问题的
                      原因是2021的IDEA和视频的IDEA不是一个版本, IDEA重构了工程文件的目录类型, 导致了把properties文件放在src/main/java下不能正常读取

                TODO: 当部署到服务器上的时候又出现了Bug -> 因为上次改用了ClassLoader. 而应该JDBCUtils.class.getClassLoader加载器
                      这样就不会有Bug了
             */
            // InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        每次调用这个方法, 仅仅是从数据库连接池中拿一个连接使用.
        而不是像之前的方法, 每次都创建一个数据池, 再从数据池中拿一个连接(这种方式更慢)
     */

    /**
     * 获取一个数据库中连接池的连接
     *
     * @return 如果返回null表示过去连接失败
     */
    public static Connection getConnection() {
        // 尝试获取一个连接 需要判断 -> 第二次取连接的时候就会有值了
        Connection conn = conns.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                // 保存到ThreadLocal中, 共后面的JDBC操作使用
                conns.set(conn);

                // 设置为手动连接
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交操作, 并释放资源
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        // 判断获取的连接是否为空 -> 非空表示之前进行过数据库操作
        if (connection != null) {
            try {
                // 提交操作
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接, 释放资源
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 用完之后一定要remove操作, 否则会出错. 因为Tomcat底层使用了线程池技术
        conns.remove();
    }


    /**
     * 提交操作失败, 回滚事务
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        // 判断获取的连接是否为空 -> 非空表示之前进行过数据库操作
        if (connection != null) {
            try {
                // 提交操作
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接, 释放资源
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 用完之后一定要remove操作, 否则会出错. 因为Tomcat底层使用了线程池技术
        conns.remove();
    }


    // 下面的代码更新, 不使用了
    /*
        因为, 每次使用完毕之后, 都需要关闭掉数据库的连接. 所以也封装成一个方法
     */
    /*
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     */




}





