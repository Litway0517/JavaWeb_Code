package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author DELL_
 * @date 2022/01/17
 */
public interface OrderService {


    /**
     * @param cart 购物车
     * @param userId 用户id 用户Id
     * @return {@link String}
     */
    public String createOrder(Cart cart, Integer userId);

}
