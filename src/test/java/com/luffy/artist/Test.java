package com.luffy.artist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]) {

        String pattern = "([\\p{Sc}])\\w{8,12}([\\p{Sc}])";
        String content = "【猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫猫】复制这条信息，$S9tTGYp336x$，到【手机淘宝】即可查看";
        String content2 = "【猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪猪】，" + "椱ァ製这段描述$SftOYhmrepl$后到?◇綯℡寳?";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        Matcher m2 = r.matcher(content2);
        m.find();
        m2.find();
        System.out.println("转换前--------------");
        System.out.println(content);
        System.out.println(content2);
        String s = m.group();
//        System.out.println(s);
        String s2 = m2.group();
//        System.out.println(s2);
        System.out.println("转换后--------------");
        System.out.println(content.replace(s ,s2));
    }
}
