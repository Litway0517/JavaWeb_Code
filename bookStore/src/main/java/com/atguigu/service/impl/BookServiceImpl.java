package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * 书服务impl
 * 书服务实现
 *
 * @author DELL
 * @date 2021/11/15
 */
public class BookServiceImpl implements BookService {

    /**
     * 书刀impl
     */ // Service的具体实现, 一般都是依赖于DAO层, 先导入
    private final BookDaoImpl bookDaoImpl = new BookDaoImpl();


    /**
     * 添加书
     * 添加的书
     *
     * @param book 书
     */
    @Override
    public void addBook(Book book) {
        bookDaoImpl.addBook(book);
    }

    /**
     * 更新书
     * 更新的书
     *
     * @param book 书
     */
    @Override
    public void updateBook(Book book) {
        bookDaoImpl.updateBook(book);
    }

    /**
     * 删除书通过id
     *
     * @param id id
     */
    @Override
    public void deleteBookById(Integer id) {
        bookDaoImpl.deleteBookById(id);
    }

    /**
     * 通过id查询书
     *
     * @param id id
     * @return {@link Book}
     */
    @Override
    public Book queryBookById(Integer id) {
        return bookDaoImpl.queryBookById(id);
    }

    /**
     * 查询图书
     *
     * @return {@link List}<{@link Book}>
     */
    @Override
    public List<Book> queryBooks() {
        return bookDaoImpl.queryBooks();
    }

    /**
     * 页面
     * 完成分页功能
     * @param pageNo   页面没有
     * @param pageSize 页面大小
     * @return {@link Page}<{@link Book}> 返回的是分好的一页的数据, 包括页码, 总记录数, 总页数, 该页的四条数目数据等.
     */
    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        return null;
    }
}
















