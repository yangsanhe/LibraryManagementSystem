package com.yangsanhe.library.vo;

/**
 * @author yangsanhe
 * @date 2019-12-30 13:00:25
 */
public class ReaderCheckVO {
    private String readerbarcode;

    private String readername;

    private String typename;

    private Integer idtype;

    private String idnumber;

    private Integer borrownumber;

    public String getReaderbarcode() {
        return readerbarcode;
    }

    public void setReaderbarcode(String readerbarcode) {
        this.readerbarcode = readerbarcode;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
        this.idnumber = idnumber;
    }

    public Integer getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(Integer borrownumber) {
        this.borrownumber = borrownumber;
    }
}
