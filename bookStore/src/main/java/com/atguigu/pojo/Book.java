package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * 书
 *
 * @author DELL
 * @date 2021/11/14
 */
public class Book {


    /**
     * id
     */
    private Integer id;
    /**
     * 书的名字
     */
    private String bookName;
    /**
     * 书的作者
     */
    private String bookAuthor;
    /**
     * 书的价格
     */
    private BigDecimal bookPrice;
    /**
     * 书的销量
     */
    private Integer bookSales;
    /**
     * 书股票
     */
    private Integer bookStock;
    /**
     * 书img路径
     */
    private String bookImgPath = "static/img/default.jpg";


    /**
     * 书
     */
    public Book() {
    }


    /**
     * 书
     *
     * @param id          id
     * @param bookName    书的名字
     * @param bookAuthor  书的作者
     * @param bookPrice   书的价格
     * @param bookSales   书的销量
     * @param bookStock   书股票
     * @param bookImgPath 书img路径
     */
    public Book(Integer id, String bookName, String bookAuthor, BigDecimal bookPrice, Integer bookSales, Integer bookStock, String bookImgPath) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookSales = bookSales;
        this.bookStock = bookStock;
        // 对传入的参数进行限制
        if (bookImgPath != null && bookImgPath.equals("")) {
            this.bookImgPath = bookImgPath;
        }
    }


    /**
     * 得到id
     *
     * @return {@code Integer}
     */
    public Integer getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 把书的名字
     *
     * @return {@code String}
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 集书的名字
     *
     * @param bookName 书的名字
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 让书的作者
     *
     * @return {@code String}
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * 集书的作者
     *
     * @param bookAuthor 书的作者
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * 让书的价格
     *
     * @return {@code BigDecimal}
     */
    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    /**
     * 本书定价
     *
     * @param bookPrice 书的价格
     */
    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * 让图书销售
     *
     * @return {@code Integer}
     */
    public Integer getBookSales() {
        return bookSales;
    }

    /**
     * 集图书销售
     *
     * @param bookSales 书的销量
     */
    public void setBookSales(Integer bookSales) {
        this.bookSales = bookSales;
    }

    /**
     * 让书股票
     *
     * @return {@code Integer}
     */
    public Integer getBookStock() {
        return bookStock;
    }

    /**
     * 集书股票
     *
     * @param bookStock 书股票
     */
    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    /**
     * 让书img路径
     *
     * @return {@code String}
     */
    public String getBookImgPath() {
        return bookImgPath;
    }

    /**
     * 集书img路径
     *
     * @param bookImgPath 书img路径
     */
    public void setBookImgPath(String bookImgPath) {
        // 对传入的参数进行限制
        if (bookImgPath != null && bookImgPath.equals("")) {
            this.bookImgPath = bookImgPath;
        }
    }


    /**
     * 字符串/
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookSales=" + bookSales +
                ", bookStock=" + bookStock +
                ", bookImgPath='" + bookImgPath + '\'' +
                '}';
    }
}
