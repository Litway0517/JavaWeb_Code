package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 车
 *
 * @author DELL_
 * @date 2022/01/14
 */public class Cart {

    /**
     * 总菌数
     */
//    private Integer totalCount;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 项目
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

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
    /*public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }*/

    /**
     * 得到总菌数
     *
     * @return {@link Integer}
     */
    public Integer getTotalCount() {
         Integer totalCount = 0;
        // 遍历商品项数组, 取出来每一件商品的具体数量, 然后求和返回
        Set<Map.Entry<Integer, CartItem>> entries = this.items.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    /**
     * 得到总价格
     *
     * @return {@link BigDecimal}
     */
    public BigDecimal getTotalPrice() {
        Set<Map.Entry<Integer, CartItem>> entries = this.items.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
//            totalPrice += entry.getValue().getPrice();
        }
        return totalPrice;
    }


    /**
     * 得到项目
     *
     * @return {@link Map}<{@link Integer}, {@link CartItem}>
     */
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    /**
     * 设置项
     *
     * @param items 项目
     */
    public void setItems(Map<Integer, CartItem> items) {
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
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }


    // ===================================================================
    /*
        下面增加实现的方法:
            - addItem(CartIem cartItem) {}
            - deleteItem(Integer id) {}
            - clearAll() {}
            - updateCount(Integer id, Integer newCount) {}
     */

    /**
     * 添加物品
     *
     * @param cartItem 车项目
     */
    public void addItem(CartItem cartItem){
        /*
            判断, 目前的items数组中, 是否已经包含了需要待加入的这个商品项. 如, items数组中已经有了 [时间简史], 那么只需要更改其数量,
                并且, 更新为两本书的价格即可.
         */
        com.atguigu.pojo.CartItem findCartItem= this.items.get(cartItem.getId());
        if (findCartItem != null) {
            // 更新数量
            findCartItem.setCount(findCartItem.getCount() + 1);
            // 更新价格 -> 注意这里更新的方式
            findCartItem.setTotalPrice(findCartItem.getPrice().multiply(new BigDecimal(findCartItem.getCount())));
        } else {
            this.items.put(cartItem.getId(), cartItem);
        }
    }

    /**
     * 删除项目
     *
     * @param id id
     */
    public void deleteItem(Integer id){
        // 这个接口会自动判断, 如果没有就该方法的话, 就不删除.
        this.items.remove(id);
    }

    /**
     * 清晰
     */
    public void clear(){
        this.items.clear();
    }

    /**
     * 更新数
     *
     * @param id    id
     * @param count 数
     */
    public void updateCount(Integer id, Integer count){
        /*
            先查看items数组中是否有改商品, 如果有, 则更新; 如果没有, 则不进行操作
         */
        CartItem findCartItem = this.items.get(id);
        if (findCartItem != null) {
            // 更新数量
            findCartItem.setCount(count);
            // 同时还需要更新该项书本的分总价格
            findCartItem.setTotalPrice(findCartItem.getPrice().multiply(new BigDecimal(findCartItem.getCount())));
        }

    }






}
