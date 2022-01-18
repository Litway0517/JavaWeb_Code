package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author DELL_
 * @date 2022/01/17
 */
public interface OrderService {


    /**
     * @param cart 购物车
     * @param userId 用户id 用户Id
     * @return {@link String}
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询所有订单(管理员功能)
     *
     * @return 所有订单
     */
    public List<Order> queryAllOrders();

    /**
     * 更改订单的状态(管理员功能)
     * @param orderId 订单id
     * @param status 新的订单状态
     */
    public void sendOrder(String orderId, Integer status);


    /**
     * 根据用户Id, 查询该用户的所有订单信息
     * @param userId 用户Id
     * @return 返回该用户下的所有订单信息
     */
    public List<Order> queryOrdersByUserId(Integer userId);


    /**
     * 根据订单id, 查询该订单下面的详细信息
     *
     * @param orderId 订单的id
     */
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
