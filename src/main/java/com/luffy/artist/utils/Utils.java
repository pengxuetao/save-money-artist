package com.luffy.artist.utils;

import java.util.UUID;

/**
 * 工具类
 */
public class Utils {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 获取随机文件名
     * @param fileName 文件名
     * @return
     */
    public static String getRandomFileName(String fileName){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        String[] arr = fileName.split("\\.");
        return uuid+"."+arr[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(Utils.getUUID());
        System.out.println(Utils.getRandomFileName("124154.123.5.jpg"));

        String[] arr = {"1","2","3"};
        StringBuilder condition = new StringBuilder();
        for(String str: arr) {
            condition.append(str+"','");
        }
        System.out.println(condition.toString());
        System.out.println(condition.toString().substring(0,condition.toString().length()-3));
    }
}
