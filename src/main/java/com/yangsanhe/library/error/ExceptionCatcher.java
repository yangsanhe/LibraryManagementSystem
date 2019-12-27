package com.yangsanhe.library.error;

import com.yangsanhe.library.response.Response;
import com.yangsanhe.library.util.LoggerUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yangsanhe
 * @date 2019-12-27 13:46:55
 */
@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response customException(CustomException e){
        LoggerUtil.e(ExceptionHandler.class,"catch Exception: \r\nException: " + e.getMessage());
        return new Response(e.getCommonError().success(),e.getCommonError().code(),e.getCommonError().message());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response exception(Exception e){
        // 未定义的异常
        LoggerUtil.e(ExceptionHandler.class,"catch Exception: \r\nException: " + e.getMessage(),e);
        if(e instanceof HttpRequestMethodNotSupportedException){
            //请求方法不支持
            return new Response(false,19998,e.getMessage());
        }
        return new Response(false,19999,e.getMessage());
    }
}
