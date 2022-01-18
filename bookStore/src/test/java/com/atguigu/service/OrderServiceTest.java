package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {

        // 测试时, 先创建一个购物车
        Cart cart = new Cart();
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));

        // 创建一个订单实现类OrderServiceImpl
        OrderServiceImpl orderService = new OrderServiceImpl();
        String order = orderService.createOrder(cart, 1);
        System.out.println("订单号是 : " + order);

    }

    @Test
    public void queryAllOrders() {

        // 测试时, 先创建一个购物车
        Cart cart = new Cart();
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));

        // 创建一个订单实现类OrderServiceImpl
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        String order = orderServiceImpl.createOrder(cart, 1);
        System.out.println("订单号是 : " + order);

        List<Order> orders = orderServiceImpl.queryAllOrders();
        System.out.println(orders);
    }

    @Test
    public void queryOrdersByUserId() {

    }



}
