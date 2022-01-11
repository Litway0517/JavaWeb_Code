package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;


/**
 * 书刀
 * 书DAO
 *
 * @author DELL
 * @date 2021/11/14
 */
public interface BookDao {


    /**
     * 添加书
     * 添加的书
     *
     * @param book 书
     * @return int
     */
    public int addBook(Book book);


    /**
     * 更新书
     * 更新的书
     *
     * @param book 书
     * @return int
     */
    public int updateBook(Book book);


    /**
     * 删除书通过id
     *
     * @param id id
     * @return int
     */
    public int deleteBookById(Integer id);

    /**
     * 通过id查询书
     *
     * @param id id
     * @return {@link Book}
     */
    public Book queryBookById(Integer id);


    /**
     * 查询图书
     *
     * @return {@link List}<{@link Book}> 查询所有图书
     */
    public List<Book> queryBooks();


    /**
     * 查询页面总数
     *
     * @return {@link Integer} 返回记录的总数, 即数据库中的表里面有多少条数据, 多少本书.
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询页面项目
     *
     * @param begin    开始
     * @param pageSize 页面大小
     * @return {@link List}<{@link Book}> 根据前端的请求, 返回该页的数据, 第1, 2, 3, ... 页
     */
    public List<Book> queryForPageItems(int begin, int pageSize);


    /**
     * 根据最小价格和最大价格进行分页(与上面不同就是添加了限制条件), 查询符合指定价格区间的图书共有多少本
     * @param minPrice 最小价格
     * @param maxPrice 最大价格
     * @return 处于指定价格区间中的书本一共有多少本
     */
    public Integer queryForPageTotalCountByPrice(int minPrice, int maxPrice);


    /**
     * 查询到该页中具体的书籍
     * @param begin 从第几条数据开始查询
     * @param pageSize 本次查询的长度. 实际上这个就是每页中书本的数量. 此时指的是4
     * @param minPrice 最小价格
     * @param maxPrice 最大价格
     * @return 第1页, 2, 3, ...
     */
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int minPrice, int maxPrice);



}
