package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * 订单DAOImpl
 *
 * @author DELL_
 * @date 2022/01/16
 */
public class OrderImpl extends BaseDao implements OrderDao {


    /**
     * 保存订单
     *
     * @param order 订单
     * @return int
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES(?,?,?,?,?)";
        return updateForOne(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
