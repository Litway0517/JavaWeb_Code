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
     * 的名字
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 销售
     */
    private Integer sales;
    /**
     * 股票
     */
    private Integer stock;
    /**
     * img路径
     */
    private String imgPath = "static/img/default.jpg";


    /**
     * 书
     */
    public Book() {
    }

    /**
     * 书
     *
     * @param id      id
     * @param name    的名字
     * @param author  作者
     * @param price   价格
     * @param sales   销售
     * @param stock   股票
     * @param imgPath img路径
     */
    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        // 对图书路径赋值的时候, 进行一下检查
        if (imgPath != null && !imgPath.equals("")) {
            this.imgPath = imgPath;
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
     * 得到的名字
     *
     * @return {@code String}
     */
    public String getName() {
        return name;
    }

    /**
     * 集名称
     *
     * @param name 的名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 让作者
     *
     * @return {@code String}
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 集的作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 得到价格
     *
     * @return {@code BigDecimal}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 固定价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 得到销售
     *
     * @return {@code Integer}
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 集销售
     *
     * @param sales 销售
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * 得到股票
     *
     * @return {@code Integer}
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 集股票
     *
     * @param stock 股票
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 得到img路径
     *
     * @return {@code String}
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * img设置路径
     *
     * @param imgPath img路径
     */
    public void setImgPath(String imgPath) {
        // 对图书路径赋值的时候, 进行一下检查
        if (imgPath != null && !imgPath.equals("")) {
            this.imgPath = imgPath;
        }
    }


    /**
     * 字符串
     *
     * @return {@code String}
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
