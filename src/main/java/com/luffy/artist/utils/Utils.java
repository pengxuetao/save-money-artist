package com.luffy.artist.utils;

import java.util.UUID;

/**
 * 工具类
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
public class Utils {

    private Utils() {
    }

    /**
     * 获取UUID
     *
     * @return String
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 获取随机文件名
     *
     * @param fileName 文件名
     * @return String
     */
    public static String getRandomFileName(String fileName) {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        String[] arr = fileName.split("\\.");
        return uuid + "." + arr[arr.length - 1];
    }

}
