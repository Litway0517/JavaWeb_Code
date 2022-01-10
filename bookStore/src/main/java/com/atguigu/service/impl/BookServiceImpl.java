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
     */
    // Service的具体实现, 一般都是依赖于DAO层, 先导入
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
        Page<Book> page = new Page<Book>();

        /*
            设置pageNo时, 出现了异常, 原因是此时还没有pageTotal值(看一下Page实体类就知道了).
            所以, 调整一下赋值顺序. pageTotal -> pageTotalCount -> pageNo
            其他顺序不做要求, 而pageNo必须在pageTotal后面赋值
         */
        // 3- 设置总记录数 -> 调用DAO层, 进行查询
        // 先查库计算总的记录数
        Integer pageTotalCount = bookDaoImpl.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        // 4- 设置总页码数
        // 先计算总页码数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        // 1- 设置当前页码
        page.setPageNo(pageNo);

        // 2- 设置每页显示的图书数量
        page.setPageSize(pageSize);

        /*
            如果地址栏中输入的页码小于1, 则最后赋值1
            如果地址栏中输入的页码大于最大页码max, 则最后赋值最大页码max
         */
        /*if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }*/


        // 5- 设置items的值, 就是查询当前页的数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDaoImpl.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }
}
















