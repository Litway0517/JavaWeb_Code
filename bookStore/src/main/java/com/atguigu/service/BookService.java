package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

/**
 * 书服务
 *
 * @author DELL
 * @date 2021/11/15
 */
public interface BookService {


    /**
     * 添加书
     * 添加的书
     *
     * @param book 书
     */
    public void addBook(Book book);

    /**
     * 更新书
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
     * @return {@link Book}
     */
    public Book queryBookById(Integer id);

    /**
     * 查询图书
     *
     * @return {@link List}<{@link Book}>
     */
    public List<Book> queryBooks();


    /**
     * 页面
     * 完成分页功能
     * @param pageNo   页面编号
     * @param pageSize 每一个页面的大小
     * @return {@link Page} 返回的是分好的一页的数据, 包括页码, 总记录数, 总页数, 该页的四条数目数据等.
     */
    public Page<Book> page(int pageNo, int pageSize);





}
