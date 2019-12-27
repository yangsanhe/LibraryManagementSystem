package com.yangsanhe.library.error;

/**
 * 自定义异常类
 * @author yangsanhe
 * @date 2019-12-27 13:35:14
 */
public class CustomException extends RuntimeException {
    private CommonError error;

    public CustomException(CommonError error){
        super("错误代码：" + error.code() + "错误信息：" + error.message());
        this.error = error;
    }

    public ResultCode getCommonError() {
        return error;
    }
}
