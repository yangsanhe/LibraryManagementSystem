package com.yangsanhe.library.response;

import static com.yangsanhe.library.util.Constant.*;

/**
 * 通用的返回对象
 * @author yangsanhe
 * @date 2019-12-27 13:27:49
 */
public class Response {

    private boolean success = SUCCESS;

    private int code = SUCCESS_CODE;

    private Object message;

    /**
     * 无参构造方法，表示请求成功，不返回对象信息
     */
    public Response() {
        this.message = SUCCESS_MESSAGE;
    }

    /**
     * 用于请求成功后，需要返回一个视图对象的业务
     * @param message 视图对象vo
     */
    public Response(Object message){
        this.message = message;
    }
    /**
     * 自定义返回类型
     * @param success   是否请求成功
     * @param code  返回码
     * @param message   返回信息
     */
    public Response(boolean success, int code, Object message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
