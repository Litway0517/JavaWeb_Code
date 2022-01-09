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





}
