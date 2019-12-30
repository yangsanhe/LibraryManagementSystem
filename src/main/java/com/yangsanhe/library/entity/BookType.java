package com.yangsanhe.library.entity;

public class BookType {
    private Integer id;

    private String typename;

    private Integer borrowdays;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getBorrowdays() {
        return borrowdays;
    }

    public void setBorrowdays(Integer borrowdays) {
        this.borrowdays = borrowdays;
    }

}