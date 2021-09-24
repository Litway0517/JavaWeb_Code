package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * 书
 *
 * @author DELL
 * @date 2021/09/24
 */
public class Book {

    private String sn;
    private String name;
    private Double price;
    private String author;


    // 无参 -> 构造方法
    public Book() {
    }

    // 含参 -> 构造方法
    public Book(String sn, String name, Double price, String author) {
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // toString方法
    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
