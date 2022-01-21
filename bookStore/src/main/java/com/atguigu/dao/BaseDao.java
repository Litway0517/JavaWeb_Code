package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * 底刀
 *
 * @author DELL
 * @date 2021/10/24
 */
public abstract class BaseDao {
    /*
        DAO -> Data access Object
        BaseDao是一个抽象类.
        就是操作数据库的基类. 但是也提供了一些确定实现的方法, 只需要传入参数即可. 存在部分抽象方法, 需要继承此类的子类重写.

     */

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * QueryRunner的update方法, 能够执行 insert/update/delete 类型的sql语句.
     * 如果不使用封装好的jar包, 那么需要单独写, 这样降低效率
     * @param sql 待执行sql语句
     * @param args 需要传入的可变参数
     * @return 如果返回-1表示操作失败。 否则返回的int值表示影响的数据库中表的行数
     *
     * conn一般不放在方法的参数中, 否则调用这个方法之前就需要创建一个conn, 这样, 创建conn的这行代码就没有被封装起来, 耦合性就高了一丢丢
     */
    public int updateForOne(String sql, Object ...args) {
        Connection conn = JDBCUtils.getConnection();

        // 观察整个 创建订单 流程的执行过程中, 线程的名称
        System.out.println("BaseDao 线程的名称: " + Thread.currentThread().getName());

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(conn);
        }
        return -1;
    }


    /**
     * 查询返回一个JavaBean对象或者返回一条记录的sql语句
     * @param bean 是查询数据库的表时, 返回的数据对象时什么类型. 其实就是pojo目录下面的JavaBean对象.
     *                  可能是一个user对象.
     * @param sql 待执行的sql语句
     * @param args 执行sql语句时, 需要有参数装配, 这个args就是该种作用. 是一个可变参数, 因为不知道需要具体传入多少个参数
     * @param <T> T就是返回的泛型, 和type一致的. 就是用来描述type
     * @return 返回的结果集合, 针对本方法是一个对象. 返回空表示查询失败
     */
    public <T> T queryForOne(Class<T> bean, String sql, Object ...args) {
        /*
            Class<T> 就是获取T对象的Class对象, 这个Class就是反射里面那个Class
         */
        Connection conn = JDBCUtils.getConnection();
        BeanHandler<T> beanHandler = new BeanHandler<>(bean);

        try {
            return queryRunner.query(conn, sql,beanHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(conn);
        }
        return null;
    }


    /**
     * 查询表中的多条数据, 返回多个JavaBean对象, 并将这些对象封装到一个List集合中
     * @param bean 返回对象的类型
     * @param sql 待执行的sql语句
     * @param args sql语句中的参数
     * @param <T> 返回的类型
     * @return 若返回null, 表示查询失败. 非空则表示查询成功
     */
    public <T> List<T> queryForList(Class<T> bean, String sql, Object ...args) {
        /*
            public 这是一个泛型方法, <T>紧跟在public后面就说明了这点. T作为泛型. 方法返回的是List列表, 列表中存储的元素的类型就是泛型T

         */
        Connection conn = JDBCUtils.getConnection();
        BeanListHandler<T> beanListHandler = new BeanListHandler<T>(bean);

        try {
            return queryRunner.query(conn, sql,beanListHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(conn);
        }
        return null;
    }


    /**
     * 执行返回一行一列的sql语句
     * @param sql SQL语句
     * @param args sql语句中的参数
     * @return 若为空则表示查询失败.
     */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection conn = JDBCUtils.getConnection();
        ScalarHandler scalarHandler = new ScalarHandler();

        try {
            return queryRunner.query(conn, sql, scalarHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(conn);
        }
        return null;

    }



}
