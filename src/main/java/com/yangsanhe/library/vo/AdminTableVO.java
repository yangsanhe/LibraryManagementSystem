package com.yangsanhe.library.vo;

/**
 * @author yangsanhe
 * @date 2019-12-29 20:47:49
 */
public class AdminTableVO {
    private Integer id;
    private String adminname;
    private Integer systemset;
    private Integer readersmanage;
    private Integer vbooksmanage;
    private Integer borrowingbooks;
    private Integer systemquery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public Integer getSystemset() {
        return systemset;
    }

    public void setSystemset(Integer systemset) {
        this.systemset = systemset;
    }

    public Integer getReadersmanage() {
        return readersmanage;
    }

    public void setReadersmanage(Integer readersmanage) {
        this.readersmanage = readersmanage;
    }

    public Integer getVbooksmanage() {
        return vbooksmanage;
    }

    public void setVbooksmanage(Integer vbooksmanage) {
        this.vbooksmanage = vbooksmanage;
    }

    public Integer getBorrowingbooks() {
        return borrowingbooks;
    }

    public void setBorrowingbooks(Integer borrowingbooks) {
        this.borrowingbooks = borrowingbooks;
    }

    public Integer getSystemquery() {
        return systemquery;
    }

    public void setSystemquery(Integer systemquery) {
        this.systemquery = systemquery;
    }
}
