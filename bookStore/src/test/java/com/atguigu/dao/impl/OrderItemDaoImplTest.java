package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItem = new OrderItemDaoImpl();
        orderItem.saveOrderItem(new OrderItem(null, "大话西游", 1, new BigDecimal("59.9"), new BigDecimal("59.9"), "test001"));

    }

    @Test
    public void queryOrderItemsByOrderId() {
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();

        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        List<Order> orders = orderDaoImpl.queryAllOrders();


        List<OrderItem> orderItems = orderItemDaoImpl.queryOrderItemsByOrderId(orders.get(orders.size() - 1).getOrderId());
        System.out.println(orderItems);


    }

}
