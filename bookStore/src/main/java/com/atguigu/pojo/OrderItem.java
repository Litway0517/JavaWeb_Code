package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * 订单项
 *
 * @author DELL_
 * @date 2022/01/16
 */
public class OrderItem {
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
     * 价格
     */
    private BigDecimal price;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 订单id
     */
    private String orderId;


    /**
     * 订单项
     */
    public OrderItem() {
    }

    /**
     * 订单项
     *
     * @param id         id
     * @param name       名字
     * @param count      数
     * @param price      价格
     * @param totalPrice 总价格
     * @param orderId    订单id
     */
    public OrderItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, String orderId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
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
     * 得到订单id
     *
     * @return {@link String}
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
