package com.yangsanhe.library.entity;

public class ReaderType {
    private Integer id;

    private String typename;

    private Integer borrownumber;

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

    public Integer getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(Integer borrownumber) {
        this.borrownumber = borrownumber;
    }
}