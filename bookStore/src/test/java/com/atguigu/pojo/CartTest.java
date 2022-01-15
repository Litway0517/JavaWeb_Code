package com.atguigu.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    private final Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal("28.8"), new BigDecimal("28.8")));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal("28.8"), new BigDecimal("28.8")));
        cart.addItem(new CartItem(12, "计算机网络", 1, new BigDecimal("100"), new BigDecimal("100")));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }
}
