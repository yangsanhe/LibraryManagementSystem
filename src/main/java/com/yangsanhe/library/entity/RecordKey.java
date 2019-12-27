package com.yangsanhe.library.entity;

public class RecordKey {
    private String bookbarcode;

    private String readerbarcode;

    public String getBookbarcode() {
        return bookbarcode;
    }

    public void setBookbarcode(String bookbarcode) {
        this.bookbarcode = bookbarcode == null ? null : bookbarcode.trim();
    }

    public String getReaderbarcode() {
        return readerbarcode;
    }

    public void setReaderbarcode(String readerbarcode) {
        this.readerbarcode = readerbarcode == null ? null : readerbarcode.trim();
    }
}