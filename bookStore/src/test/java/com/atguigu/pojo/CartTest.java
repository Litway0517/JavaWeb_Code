package com.atguigu.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 车测试
 *
 * @author DELL_
 * @date 2022/01/15
 */
/*
    存在bug
        - add方法
        - delete方法
 */
public class CartTest {

    /**
     * 添加物品
     */
    @Test
    public void addItem() {
        /*
            如果, 一上来的数量就超过1, 比如, 初始化的时候, '黑客帝国 矩阵'的数量为2, 但是单价和分总价格填的都是30时, 会引起bug
         */
        Cart cart = new Cart();
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
    }

    /**
     * 删除项目
     */
    @Test
    public void deleteItem() {
        /*
            删除的时候, 是根据id删除的, 所以说将购物车中, 属于该类的物品全部删掉, 而不是数量减一. 数量上的减少, 还需要再完善
         */
        Cart cart = new Cart();

        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));

        // 删除一个商品
        cart.deleteItem(10);

        System.out.println(cart);
    }

    /**
     * 清晰
     */
    @Test
    public void clear() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 2, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));

        // 清空购物车
        cart.clear();

        System.out.println(cart);
    }

    /**
     * 更新数
     */
    @Test
    public void updateCount() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));
        cart.addItem(new CartItem(20, "计算机网络", 1, new BigDecimal(100), new BigDecimal(100)));

        // 清空购物车
        cart.clear();

        cart.addItem(new CartItem(10, "黑客帝国 矩阵", 1, new BigDecimal(30), new BigDecimal(30)));

        cart.updateCount(10, 10);
        System.out.println(cart);
    }
}
