package com.atguigu.dao.impl;

import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemImpl orderItem = new OrderItemImpl();
        orderItem.saveOrderItem(new OrderItem(null, "大话西游", 1, new BigDecimal("59.9"), new BigDecimal("59.9"), "test001"));

    }
}
