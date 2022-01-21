package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.List;

/**
 * 订单DAOImpl
 *
 * @author DELL_
 * @date 2022/01/16
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {


    /**
     * 保存订单
     *
     * @param order 订单
     * @return int
     */
    @Override
    public int saveOrder(Order order) {

        // 观察整个 创建订单 流程的执行过程中, 线程的名称
//        System.out.println("orderDaoImpl 线程的名称: " + Thread.currentThread().getName());

        String sql = "INSERT INTO t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES(?,?,?,?,?)";
        return updateForOne(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }


    /**
     * 查询所有订单
     *
     * @return 返回所有订单的数目
     */
    @Override
    public List<Order> queryAllOrders() {
        String sql = "SELECT `order_id` orderId,`create_time` createTime,`price` price,`status` `status`,`user_id` userId  FROM `t_order`";
        List<Order> orders = queryForList(Order.class, sql);
        return orders;
    }


    /**
     * 更改订单的状态(管理员功能)
     * @param orderId 订单id
     * @param status 新的订单状态
     */
    @Override
    public int sendOrder(String orderId, Integer status) {
        String sql = "UPDATE `t_order` SET `status` = ? WHERE `order_id` = ?";
        int i = updateForOne(sql, status, orderId);
        return i;
    }

    /**
     * 根据用户Id, 查询该用户的所有订单信息
     *
     * @param userId 用户Id
     * @return 返回该用户下的所有订单信息
     */
    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "SELECT `order_id` `orderId`,`create_time` `createTime`,`price` `price`,`status` `status`,`user_id` `userId` FROM `t_order` WHERE `user_id` = ?";
        List<Order> orders = queryForList(Order.class, sql, userId);
        return orders;
    }
}
