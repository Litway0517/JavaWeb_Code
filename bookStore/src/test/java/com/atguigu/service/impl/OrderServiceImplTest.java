package com.atguigu.service.impl;

import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

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
    public void sendOrder() {
    }

    @Test
    public void queryOrdersByUserId() {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

        List<Order> orders = orderServiceImpl.queryOrdersByUserId(1);
        System.out.println(orders);
        System.out.println(orders.size());


    }


    @Test
    public void queryOrderItemsByOrderId() {
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        List<Order> orders = orderDaoImpl.queryAllOrders();

        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        List<OrderItem> orderItems = orderItemDaoImpl.queryOrderItemsByOrderId(orders.get(orders.size() - 1).getOrderId());
        System.out.println(orderItems);

    }

}
