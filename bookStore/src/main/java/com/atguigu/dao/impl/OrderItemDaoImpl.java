package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 * 订单中的明细分类DAOImpl
 *
 * @author DELL_
 * @date 2022/01/16
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    /**
     * 保存订单项
     *
     * @param orderItem 订单项
     * @return int
     */
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item(`name`, `count`, `price`, `total_price`, `order_id`) VALUES(?,?,?,?,?)";
        return updateForOne(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
