package com.yangsanhe.library.entity;

public class Bookshelf {
    private Integer id;

    private String bookshelfname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookshelfname() {
        return bookshelfname;
    }

    public void setBookshelfname(String bookshelfname) {
        this.bookshelfname = bookshelfname == null ? null : bookshelfname.trim();
    }
}