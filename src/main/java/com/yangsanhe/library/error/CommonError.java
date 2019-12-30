package com.yangsanhe.library.error;

/**
 * @author yangsanhe
 * @date 2019-12-27 13:39:55
 */
public enum CommonError implements ResultCode {
    /**
     * 10001 未认证登录系统
     */
    UNAUTHENTICATED(false,10001,"此操作需要登录系统"),
    /**
     * 10002 权限不足
     */
    UNAUTHORISED(false,10002,"权限不足，无权访问"),
    /**
     * 10003 非法参数
     */
    INVALID_PARAM(false,10003,"非法参数！"),
    /**
     * 19999 未知异常
     */
    UNKNOWN_ERROR(false,19999,"未知异常"),
    /**
     * 20001 登陆失败
     */
    LOGIN_FAILED(false,20001,"用户名或密码输入错误"),
    /**
     * 99999 服务器繁忙
     */
    BUSY_SERVER(false,99999,"系统繁忙，请稍后再试");
    //异常类型可以在这里继续定义无限个

    /**
     * 操作是否成功
     */
    private boolean success;
    /**
     * 返回码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

    CommonError(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
