package com.yangsanhe.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yangsanhe
 * @date 2019-12-27 14:32:20
 */
public class LoggerUtil {
    /**
     * 是否开启Debug
     */
    private static boolean debug = LogManager.getLogger(LoggerUtil.class).isDebugEnabled();

    /**
     * Info 输出
     * @param message 输出信息
     */
    public static void i(String message){
        Logger logger = LogManager.getLogger();
        logger.info(message);
    }

    /**
     * Info 输出
     * @param clazz 指定的Class
     * @param message 输出信息
     */
    public static void i(Class<?> clazz, String message) {
        Logger logger = LogManager.getLogger(clazz);
        logger.info(message);
    }

    /**
     * Debug 输出
     * @param clazz 指定的Class
     * @param message 输出信息
     */
    public static void d(Class<?> clazz, String message) {
        if (!debug) {
            return;
        }
        Logger logger = LogManager.getLogger(clazz);
        logger.debug(message);
    }

    /**
     * Error 输出
     * @param clazz 指定的Class
     * @param message 输出信息
     */
    public static void e(Class<?> clazz, String message) {
        e(clazz,message,null);
    }

    /**
     * Error 输出
     * @param clazz 指定的Class
     * @param message 输出信息
     * @param e 异常类
     */
    public static void e(Class<?> clazz, String message, Exception e) {
        Logger logger = LogManager.getLogger(clazz);
        if (null == e) {
            logger.error(message);
        } else {
            logger.error(message,e);
        }
    }

}
