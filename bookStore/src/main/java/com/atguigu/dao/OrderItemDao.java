package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

/**
 * 订单项刀
 *
 * @author DELL_
 * @date 2022/01/16
 */
public interface OrderItemDao {

    /**
     * 保存订单项
     *
     * @param orderItem 订单项
     * @return int
     */
    public int saveOrderItem(OrderItem orderItem);

}
