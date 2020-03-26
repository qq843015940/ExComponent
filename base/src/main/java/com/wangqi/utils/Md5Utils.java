package com.wangqi.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Md5Utils {

    public static String getMd5(String dataStr) {
        String slat = "exedu";
        dataStr = dataStr + slat;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (byte b : s) {
                result.append(Integer.toHexString((0x000000FF & b) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataStr;
    }
}
