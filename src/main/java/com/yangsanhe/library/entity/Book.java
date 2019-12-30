package com.yangsanhe.library.entity;

import java.math.BigDecimal;

public class Book {
    private String bookbarcode;

    private String bookname;

    private Integer booktype;

    private String author;

    private String translator;

    private String press;

    private BigDecimal price;

    private Integer pagenumber;

    private Integer bookshelf;

    private Integer ifexit;

    private String borrowtimes;

    public String getBookbarcode() {
        return bookbarcode;
    }

    public void setBookbarcode(String bookbarcode) {
        this.bookbarcode = bookbarcode == null ? null : bookbarcode.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getBooktype() {
        return booktype;
    }

    public void setBooktype(Integer booktype) {
        this.booktype = booktype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
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
        this.borrowtimes = borrowtimes == null ? null : borrowtimes.trim();
    }
}