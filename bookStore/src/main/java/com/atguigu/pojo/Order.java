package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author DELL_
 * @date 2022/01/16
 */
public class Order {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 订单状态
     * 0=未发货, 1=已发货, 2=已签收
     */
    private Integer orderStatus = 0;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单
     */
    public Order() {
    }

    /**
     * 订单
     *
     * @param orderId     订单id
     * @param createTime  创建时间
     * @param price       价格
     * @param orderStatus 订单状态
     * @param userId      用户id
     */
    public Order(String orderId, Date createTime, BigDecimal price, Integer orderStatus, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.orderStatus = orderStatus;
        this.userId = userId;
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
     * 有创建时间
     *
     * @return {@link Date}
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * 得到订单状态
     *
     * @return {@link Integer}
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 得到用户id
     *
     * @return {@link Integer}
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", userId=" + userId +
                '}';
    }
}
