package com.atguigu.dao;

import com.atguigu.pojo.Order;

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



}
