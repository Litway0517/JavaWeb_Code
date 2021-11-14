package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;


/**
 * 书DAO
 *
 * @author DELL
 * @date 2021/11/14
 */
public interface BookDao {


    /**
     * 添加的书
     *
     * @param book 书
     * @return int
     */
    public int addBook(Book book);


    /**
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
     * @return {@code Book}
     */
    public Book queryBookById(Integer id);


    /**
     * 查询图书
     *
     * @return {@code List<Book>}
     */
    public List<Book> queryBooks();






}
