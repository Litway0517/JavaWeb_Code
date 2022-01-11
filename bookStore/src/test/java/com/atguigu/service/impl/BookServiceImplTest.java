package com.atguigu.service.impl;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 书服务实现测试
 *
 * @author DELL
 * @date 2021/11/15
 */
public class BookServiceImplTest {

    private final BookServiceImpl bookServiceImpl = new BookServiceImpl();

    @Test
    public void addBook() {
        bookServiceImpl.addBook(new Book(null, "国哥在手, 天下我有!", "11259", new BigDecimal(10151), 10000000, 0, null, null));
    }

    @Test
    public void updateBook() {
        bookServiceImpl.updateBook(new Book(13, "大话西游", "罗贯中", new BigDecimal("35.7"), 5926, 3373, null, null));
    }

    @Test
    public void deleteBookById() {
        bookServiceImpl.deleteBookById(27);
    }

    @Test
    public void queryBookById() {
        bookServiceImpl.queryBookById(12);
    }

    @Test
    public void queryBooks() {
        System.out.println("第一种输出 -> enhanced for, 最方便的");
        for (Book book : bookServiceImpl.queryBooks()) {
            System.out.println(book);
        }

        System.out.println("第二种遍历 -> 使用迭代器, 别忘了");
        Iterator<Book> iterator = bookServiceImpl.queryBooks().iterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookServiceImpl.page(2, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookServiceImpl.pageByPrice(1, 4, 0, 10);
        System.out.println(page);
    }

}
