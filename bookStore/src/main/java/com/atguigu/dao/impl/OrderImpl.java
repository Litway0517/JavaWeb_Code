package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

public class OrderImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES(?,?,?,?,?)";
        return updateForOne(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
