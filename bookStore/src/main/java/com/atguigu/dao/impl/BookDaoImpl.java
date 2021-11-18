package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 添加的书
     *
     * @param book 书
     * @return int
     */
    @Override
    public int addBook(Book book) {

        String sql = "INSERT INTO t_book(`book_name`,`book_author`,`book_price`,`book_sales`,`book_stock`,`del_flag`,`book_img_path`) VALUES(?,?,?,?,?,?,?)";

        return updateForOne(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookSales(), book.getBookStock(), null, book.getBookImgPath());
    }

    /**
     * 更新的书
     *
     * @param book 书
     * @return int
     */
    @Override
    public int updateBook(Book book) {

        String sql = "UPDATE t_book SET `book_name`=?,`book_author`=?,`book_price`=?,`book_sales`=?,`book_stock`=?,`del_flag`=?,`book_img_path`=? WHERE id=?";

        return updateForOne(sql, book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookSales(), book.getBookStock(), null, book.getBookImgPath(), book.getId());
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
     * @return {@code Book}
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT `id`,`book_name` `bookName`,`book_author` `bookAuthor`,`book_price` `bookPrice`,`book_sales` `bookSales`,`book_stock` `bookStock`,`del_flag` `bookDelFlag`,`book_img_path` `bookImgPath` FROM t_book WHERE `del_flag` = '0' AND `id`=?";
        return queryForOne(Book.class, sql, id);
    }

    /**
     * 查询图书
     *
     * @return {@code List<Book>}
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT `id`,`book_name` `bookName`,`book_author` `bookAuthor`,`book_price` `bookPrice`,`book_sales` `bookSales`,`book_stock` `bookStock`,`del_flag` `bookDelFlag`,`book_img_path` `bookImgPath` FROM t_book WHERE `del_flag` = '0' ";
        return queryForList(Book.class, sql);
    }
}
