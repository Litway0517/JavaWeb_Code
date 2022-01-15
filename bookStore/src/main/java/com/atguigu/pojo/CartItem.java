package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * 车项目
 * 购物车
 *
 * @author DELL_
 * @date 2022/01/14
 */
public class CartItem {
    /**
     * id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 数
     */
    private Integer count;
    /**
     * 价格, 单价. 一本书的价格.
     */
    private BigDecimal price;
    /**
     * 总价格, 购买的数量 * 单价 = 分总价格
     */
    private BigDecimal totalPrice;

    /**
     * 车项目
     */
    public CartItem() {
    }

    /**
     * 车项目
     *
     * @param id         id
     * @param name       名字
     * @param count      数
     * @param price      价格
     * @param totalPrice 总价格
     */
    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    /**
     * 得到id
     *
     * @return {@link Integer}
     */
    public Integer getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 得到名字
     *
     * @return {@link String}
     */
    public String getName() {
        return name;
    }

    /**
     * 集名称
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 得到数
     *
     * @return {@link Integer}
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 组数
     *
     * @param count 数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 得到价格
     *
     * @return {@link BigDecimal}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 固定价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 得到总价格
     *
     * @return {@link BigDecimal}
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价格
     *
     * @param totalPrice 总价格
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
