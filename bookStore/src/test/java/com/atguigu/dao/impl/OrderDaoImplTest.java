package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDaoImpl order = new OrderDaoImpl();
        order.saveOrder(new Order("test001", new Date(), new BigDecimal("23.3"), 0, 11));

    }
}
