package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

/**
 * 订单DAO
 *
 * @author DELL_
 * @date 2022/01/16
 */
public interface OrderDao {


    /**
     * 保存订单
     *
     * @param order 订单
     * @return int
     */
    public int saveOrder(Order order);

    /**
     * 查询所有订单
     * @return 返回所有订单的数目
     */
    public List<Order> queryAllOrders();

    /**
     * 更改订单的状态(管理员功能)
     * @param orderId 订单id
     * @param status 新的订单状态
     */
    public int changeOrderStatus(String orderId, Integer status);


    /**
     * 根据用户Id, 查询该用户的所有订单信息
     * @param userId 用户Id
     * @return 返回该用户下的所有订单信息
     */
    public List<Order> queryOrdersByUserId(Integer userId);
}
