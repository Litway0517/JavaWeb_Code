package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;


public class BookDaoTest {


    BookDao bookDaoImpl = new BookDaoImpl();


    @Test
    public void addBook() {

        bookDaoImpl.addBook(new Book(null, "国哥为什么那么帅?", "国哥", new BigDecimal(9999), 99999, 0, null, null));
    }

    @Test
    public void updateBook() {

        bookDaoImpl.updateBook(new Book(23, "大家都可以这么帅", "国哥", new BigDecimal(999999), 101351, 15131351, null, null));
    }

    @Test
    public void deleteBookById() {
        bookDaoImpl.deleteBookById(24);
    }

    @Test
    public void queryBookById() {
        Book book = bookDaoImpl.queryBookById(15);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDaoImpl.queryBooks();
        books.forEach(System.out::println);

    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDaoImpl.queryForPageTotalCount());
    }


    @Test
    public void queryForPageItems() {
        for (Book book : bookDaoImpl.queryForPageItems(0, 4)) {
            System.out.println(book);
        }

    }


    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDaoImpl.queryForPageTotalCountByPrice(0, 10));
    }


    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDaoImpl.queryForPageItemsByPrice(0, Page.PAGE_SIZE, 0, 10)) {
            System.out.println(book);
        }

    }
}
