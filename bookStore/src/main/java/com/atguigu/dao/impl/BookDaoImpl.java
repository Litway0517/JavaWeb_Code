package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 书刀impl
 *
 * @author DELL_
 * @date 2022/01/09
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 添加书
     * 添加的书
     *
     * @param book 书
     * @return int
     */
    @Override
    public int addBook(Book book) {

        String sql = "INSERT INTO t_book(`book_name`,`book_author`,`book_price`,`book_sales`,`book_stock`,`del_flag`,`book_img_path`) VALUES(?,?,?,?,?,?,?)";

        return updateForOne(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookSales(), book.getBookStock(), book.getBookDelFlag(), book.getBookImgPath());
    }

    /**
     * 更新书
     * 更新的书
     *
     * @param book 书
     * @return int
     */
    @Override
    public int updateBook(Book book) {

        String sql = "UPDATE t_book SET `book_name`=?,`book_author`=?,`book_price`=?,`book_sales`=?,`book_stock`=?,`del_flag`=?,`book_img_path`=? WHERE id=?";

        return updateForOne(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookSales(), book.getBookStock(), book.getBookDelFlag(), book.getBookImgPath(), book.getId());
    }

    /**
     * 删除书通过id
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteBookById(Integer id) {
//        String sql = "DELETE FROM t_book WHERE id=?";
        // 增加一个软删除功能
        String sql = "UPDATE t_book tb SET tb.`del_flag` = '2' WHERE tb.id=?";
        return updateForOne(sql, id);
    }

    /**
     * 通过id查询书
     *
     * @param id id
     * @return {@link Book}
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`,`book_name` `bookName`,`book_author` `bookAuthor`,`book_price` `bookPrice`,`book_sales` `bookSales`,`book_stock` `bookStock`,`del_flag` `bookDelFlag`,`book_img_path` `bookImgPath` FROM t_book WHERE `del_flag` = '0' AND `id`=?";
        return queryForOne(Book.class, sql, id);
    }

    /**
     * 查询图书
     *
     * @return {@link List}<{@link Book}>
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id`,`book_name` `bookName`,`book_author` `bookAuthor`,`book_price` `bookPrice`,`book_sales` `bookSales`,`book_stock` `bookStock`,`del_flag` `bookDelFlag`,`book_img_path` `bookImgPath` FROM t_book WHERE `del_flag` = '0' ";
        return queryForList(Book.class, sql);
    }

    /**
     * 查询页面总数
     *
     * @return {@link Integer} 返回记录的总数, 即数据库中的表里面有多少条数据, 多少本书.
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "SELECT COUNT(*) FROM `t_book` WHERE `del_flag` = 0";
        /*
            这里, queryForSingleValue(sql)是从数据库中查询得到的, 返回的是Long类型的数据, 为了避免溢出. 不能直接用Integer接收.
            所以用了Number, Number是所有包装类的父类.
         */
        Number num = (Number) queryForSingleValue(sql);
        return num.intValue();
    }

    /**
     * 查询页面项目
     *
     * @param begin    开始
     * @param pageSize 页面大小
     * @return {@link List}<{@link Book}> 根据前端的请求, 返回该页的数据, 第1, 2, 3, ... 页
     */
    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "SELECT `id`,`book_name` `bookName`,`book_author` `bookAuthor`,`book_price` `bookPrice`,`book_sales` `bookSales`,`book_stock` `bookStock`,`del_flag` `bookDelFlag`,`book_img_path` `bookImgPath` FROM t_book WHERE `del_flag` = '0' LIMIT ?,?";
        List<Book> books = queryForList(Book.class, sql, begin, pageSize);
        return books;
    }

}
