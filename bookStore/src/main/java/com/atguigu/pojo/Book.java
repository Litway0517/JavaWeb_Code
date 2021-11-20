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
     * 本德尔国旗
     */
    private String bookDelFlag = "0";
    /**
     * 书img路径
     */
    private String bookImgPath = "static/img/default.jpg";


    public Book() {
    }

    public Book(Integer id, String bookName, String bookAuthor, BigDecimal bookPrice, Integer bookSales, Integer bookStock, String bookDelFlag, String bookImgPath) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookSales = bookSales;
        this.bookStock = bookStock;
        this.bookDelFlag = bookDelFlag;
        if (bookImgPath != null && bookImgPath.equals("")) {
            this.bookImgPath = bookImgPath;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookSales() {
        return bookSales;
    }

    public void setBookSales(Integer bookSales) {
        this.bookSales = bookSales;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookDelFlag() {
        return bookDelFlag;
    }

    public void setBookDelFlag(String bookDelFlag) {
        this.bookDelFlag = bookDelFlag;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        if (bookImgPath != null && bookImgPath.equals("")) {
            this.bookImgPath = bookImgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookSales=" + bookSales +
                ", bookStock=" + bookStock +
                ", bookDelFlag='" + bookDelFlag + '\'' +
                ", bookImgPath='" + bookImgPath + '\'' +
                '}';
    }
}
