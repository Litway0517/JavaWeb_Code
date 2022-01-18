package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.util.List;

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

    /**
     * 根据订单号查询订单的明细
     * @param orderId 订单号
     * @return 返回订单明细
     */
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
