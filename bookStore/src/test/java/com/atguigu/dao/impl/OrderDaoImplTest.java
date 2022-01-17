package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoImplTest {

    public OrderDaoImpl order = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        order.saveOrder(new Order("test001", new Date(), new BigDecimal("23.3"), 0, 11));
    }


    @Test
    public void queryAllOrders() {

        List<Order> orders = order.queryAllOrders();
        System.out.println(orders);
    }


}

