package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoImplTest {

    public OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDaoImpl.saveOrder(new Order("test001", new Date(), new BigDecimal("23.3"), 0, 11));
    }


    @Test
    public void queryAllOrders() {

        List<Order> orders = orderDaoImpl.queryAllOrders();
        System.out.println(orders);
    }

    @Test
    public void sendOrder() {
        List<Order> orders = orderDaoImpl.queryAllOrders();

        // 修改订单状态之前, 这里仅仅以第一个订单的状态为例子
        System.out.println("订单状态修改之前 : " + orders.get(2));

        // 修改订单状态为1
        orderDaoImpl.sendOrder(orders.get(2).getOrderId(), 1);

        System.out.println("订单状态修改之后 : " + orderDaoImpl.queryAllOrders().get(2));
    }

    @Test
    public void queryOrdersByUserId() {
        OrderDaoImpl OrderDaoImpl = new OrderDaoImpl();

        List<Order> orders = orderDaoImpl.queryOrdersByUserId(1);
        System.out.println(orders);
        System.out.println(orders.size());

    }



}

