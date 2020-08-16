package com.via.viapigeon.utils;

import android.util.Base64;

public class Base64Utils {
    /**
     * 加密
     */
    public static String encode(String data) {
        byte[] base64 = Base64.encode(data.getBytes(), Base64.DEFAULT);
        String result = new String(base64);
        return replaceBlank(result);
    }

    public static String encodeByte(byte[] data) {
        byte[] base64 = Base64.encode(data, Base64.DEFAULT);
        String result = new String(base64);
        return replaceBlank(result);
    }

    /**
     * 解密
     */
    public static String decode(String data) {
        byte[] base64 = Base64.decode(data.getBytes(), Base64.DEFAULT);
        return new String(base64);
    }

    public static byte[] decodeByte(String data) {
        byte[] base64 = Base64.decode(data.getBytes(), Base64.DEFAULT);
        return base64;
    }

    /**
     * 替换空格
     */
    public static String replaceBlank(String result) {
        if (isNullOrEmpty(result)) {
            return result;
        }
        return result.replace("\n", "");
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return true 为空
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }
}
