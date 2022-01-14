package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 车
 *
 * @author DELL_
 * @date 2022/01/14
 */
public class Cart<T> {

    /**
     * 总菌数
     */
    private Integer totalCount;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 项目
     */
    private List<T> items;

    /**
     * 车
     */
    public Cart() {
    }

    /**
     * 车
     *
     * @param totalCount 总菌数
     * @param totalPrice 总价格
     * @param items      项目
     */
    public Cart(Integer totalCount, BigDecimal totalPrice, List<T> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    /**
     * 得到总菌数
     *
     * @return {@link Integer}
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总菌数
     *
     * @param totalCount 总菌数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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
     * 得到项目
     *
     * @return {@link List}<{@link T}>
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * 设置项
     *
     * @param items 项目
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
