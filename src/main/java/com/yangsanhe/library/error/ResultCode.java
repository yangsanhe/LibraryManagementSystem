package com.yangsanhe.library.error;

/**
 * 返回对象的接口
 * @author aabbcczhy
 * @date 2019-12-27 13:23:04
 */
public interface ResultCode {
    /**
     * 操作是否成功
     * @return true:成功  false:失败
     */
    boolean success();

    /**
     * 通用返回码
     * @return 返回码
     * 10000 -- 通用的错误代码
     * 20000 -- 管理员错误代码
     * ...待补充 TODO
     */
    int code();

    /**
     * 如果成功，可以返回接口需要的对象或者直接提示请求成功
     * 如果失败，则返回可以被前端处理的错误信息
     * @return 提示信息
     */
    String message();

}
