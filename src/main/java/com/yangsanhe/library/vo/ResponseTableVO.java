package com.yangsanhe.library.vo;

/**
 * @author yangsanhe
 * @date 2019-12-29 20:50:42
 */
public class ResponseTableVO {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public ResponseTableVO(int count,Object data) {
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
