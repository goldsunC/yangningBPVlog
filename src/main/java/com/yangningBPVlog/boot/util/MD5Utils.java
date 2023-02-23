package com.yangningBPVlog.boot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */


//主要用来MD5数据加密
public class MD5Utils {

    /**
     * @Param:str 要加密的字符串
     * @return    加密后的字符串
     * */

    public static String Code(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] byteDigest = messageDigest.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));
            }
            //32位加密
            return buffer.toString();
            //16位的加密
            //return buffer.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
