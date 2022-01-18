package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;

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

}
