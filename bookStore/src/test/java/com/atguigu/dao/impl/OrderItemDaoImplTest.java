package com.atguigu.dao.impl;

import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItem = new OrderItemDaoImpl();
        orderItem.saveOrderItem(new OrderItem(null, "大话西游", 1, new BigDecimal("59.9"), new BigDecimal("59.9"), "test001"));

    }
}
