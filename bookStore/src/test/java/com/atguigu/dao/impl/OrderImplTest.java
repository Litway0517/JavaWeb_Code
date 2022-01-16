package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderImplTest {

    @Test
    public void saveOrder() {
        OrderImpl order = new OrderImpl();
        order.saveOrder(new Order("test001", new Date(), new BigDecimal("23.3"), 0, 11));

    }
}
