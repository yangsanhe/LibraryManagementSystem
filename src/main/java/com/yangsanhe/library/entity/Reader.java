package com.yangsanhe.library.entity;

public class Reader {
    private String readerbarcode;

    private String readername;

    private Integer sex;

    private Integer readertype;

    private String job;

    private String birthday;

    private Integer idtype;

    private String idnumber;

    private String telephone;

    private String email;

    private String desc;

    private Integer borrownumber;

    private Integer totalnumber;

    public String getReaderbarcode() {
        return readerbarcode;
    }

    public void setReaderbarcode(String readerbarcode) {
        this.readerbarcode = readerbarcode == null ? null : readerbarcode.trim();
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername == null ? null : readername.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getReadertype() {
        return readertype;
    }

    public void setReadertype(Integer readertype) {
        this.readertype = readertype;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(Integer borrownumber) {
        this.borrownumber = borrownumber;
    }

    public Integer getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(Integer totalnumber) {
        this.totalnumber = totalnumber;
    }
}