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
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * 项目
     */
    /*
        Cart购物车实体类的items这个成员变量没必要使用泛型, 因为这个集合种存放的就是CartItem, 而CartItem本身就是一个可变的类了,
        这个CartItem可以是书, 生活用品, 电子产品你等, 因为CartItem的name属性就可以分辨了.
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 车
     */
    public Cart() {
    }

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
        // 这里面不使用成员变量的totalCount, 因为那样在初始化Cart实体类时, 就会占用内存.
        Integer totalCount = 0;
        // 遍历商品项数组, 取出来每一件商品的具体数量, 然后求和返回
        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
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
        BigDecimal totalPrice = new BigDecimal(0);
        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            // 注意这里的累加方式. 注意累加的是每一种商品的分总价格, 即一本书30元, 若这本数量为2, 则为60元.
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
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
                ", totalPrice=" + getTotalPrice() +
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
        CartItem findCartItem= items.get(cartItem.getId());
        if (findCartItem == null) {
            // 商品项的 键=商品的id, 值=商品的内容(包括id, name, count, price单价, totalPrice分总价格)
            items.put(cartItem.getId(), cartItem);
        } else {
            // 更新数量
            findCartItem.setCount(findCartItem.getCount() + 1);
            /*
                更新价格 -> 注意这里更新的方式
                这里面更新的是, 仔细看, 更新的是由id值去Cart实体类对象中的items数组查询得到的一种的具体的商品(如Java图书),
                然后设置这个商品的一个小的总价格, 因此测试那一部分也就正常了.
             */
            findCartItem.setTotalPrice(findCartItem.getPrice().multiply(new BigDecimal(findCartItem.getCount())));
        }
    }

    /**
     * 删除项目
     *
     * @param id id
     */
    public void deleteItem(Integer id){
        // 这个接口会自动判断, 如果没有就该方法的话, 就不删除.
        items.remove(id);
    }

    /**
     * 清晰
     */
    public void clear(){
        items.clear();
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
        CartItem findCartItem = items.get(id);
        if (findCartItem != null) {
            // 更新数量
            findCartItem.setCount(count);
            // 同时还需要更新该项书本的分总价格
            findCartItem.setTotalPrice(findCartItem.getPrice().multiply(new BigDecimal(findCartItem.getCount())));
        }

    }






}
