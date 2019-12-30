package com.yangsanhe.library.vo;

import java.math.BigDecimal;

/**
 * @author yangsanhe
 * @date 2019-12-29 21:40:39
 */
public class BookTableVO {
    private String bookbarcode;

    private String bookname;

    private String typename;

    private String author;

    private String translator;

    private String press;

    private BigDecimal price;

    private Integer pagenmuber;

    private Integer bookshelf;

    private Integer ifexit;

    private String borrowtimes;

    public String getBookbarcode() {
        return bookbarcode;
    }

    public void setBookbarcode(String bookbarcode) {
        this.bookbarcode = bookbarcode;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPagenmuber() {
        return pagenmuber;
    }

    public void setPagenmuber(Integer pagenmuber) {
        this.pagenmuber = pagenmuber;
    }

    public Integer getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Integer bookshelf) {
        this.bookshelf = bookshelf;
    }

    public Integer getIfexit() {
        return ifexit;
    }

    public void setIfexit(Integer ifexit) {
        this.ifexit = ifexit;
    }

    public String getBorrowtimes() {
        return borrowtimes;
    }

    public void setBorrowtimes(String borrowtimes) {
        this.borrowtimes = borrowtimes;
    }
}
