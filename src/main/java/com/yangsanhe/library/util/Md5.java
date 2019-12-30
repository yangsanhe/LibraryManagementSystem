package com.yangsanhe.library.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author yangsanhe
 * @date 2019-12-29 20:27:28
 */
public class Md5 {

    public static String encodePassword(String password, String salt){
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleHash result = new SimpleHash("md5", password, byteSalt, 2);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Md5.encodePassword("123456","root"));
    }
}
