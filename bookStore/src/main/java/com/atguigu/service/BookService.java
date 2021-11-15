package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * 书服务
 *
 * @author DELL
 * @date 2021/11/15
 */
public interface BookService {


    /**
     * 添加的书
     *
     * @param book 书
     */
    public void addBook(Book book);

    /**
     * 更新的书
     *
     * @param book 书
     */
    public void updateBook(Book book);

    /**
     * 删除书通过id
     *
     * @param id id
     */
    public void deleteBookById(Integer id);

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
