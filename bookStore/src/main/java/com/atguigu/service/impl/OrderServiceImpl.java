package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    // 创建一个 订单DAO 对象
    OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

    // 创建一个 订单明细DAO对象
    OrderItemDaoImpl orderItemImpl = new OrderItemDaoImpl();

    // 创建一个 图书DAO对象
    private BookDaoImpl bookDaoImpl = new BookDaoImpl();

    /**
     * 创建订单
     *
     * @param cart   购物车
     * @param userId 用户id 用户Id
     * @return 返回的是订单号
     */
    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 这就是订单的id, 确保这个订单ID是唯一的 -> 通过时间戳+userId确保. 双十一零点的时候很多用户会等待秒杀, 时间戳也不能保证唯一性.
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        /*
            保存订单. 要先保存订单, 否则保存订单项的时候, 会出现外键约束错误, 这样订单项就不可能插入到数据库.
            订单项: 就是购物车中的每一个商品的信息. 购物车中的一条一条的商品信息
         */
        orderDaoImpl.saveOrder(order);

        /*
            保存订单项. 这样把购物车中的items这个成员变量, 转换为一个一个的orderItem对象, 然后调用保存DAO.
            遍历保存到数据库.
         */
        OrderItem orderItem;
        for ( Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet() ) {
            CartItem cartItem = entry.getValue();
            // 注意, 这个订单项的编号, 可以不以购物车中商品项的id为准. 订单项的id没有什么强制约束, 可以是随意的. 因此这里让数据库决定.
            orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemImpl.saveOrderItem(orderItem);

            /*
                图书的数据, 也需要更改. 图书的销量, 图书的库存都需要改.
                根据图书的id查询到对应图书的信息, 然后更新.
                    - 图书A的销量为 = A原来的销量 + A在购物车中的数量
                    - 图书A的库存为 = A原来的库存 - A在购物车中的数量
             */
            Book book = bookDaoImpl.queryBookById(cartItem.getId());
            book.setBookStock(book.getBookStock() - cartItem.getCount());
            book.setBookSales(book.getBookSales() + cartItem.getCount());
            // 保存更新
            bookDaoImpl.updateBook(book);

        }

        // 清空购物车
        cart.clear();

        // 返回的订单号
        return orderId;
    }
}
