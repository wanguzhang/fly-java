package com.fly.study.java;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author 张攀钦
 * @date 2019-10-24-22:09
 * @description 学习 String
 */
public class StringStudy {

    @Test
    public void run1() {
        String a="a";
        System.out.println(a);
        String b="\u261d";
        System.out.println(b);
    }

    @Test
    public void run2() {
//        专和且码点的十进制
        int[] strCodePoint={19987,19988};
        final String s = new String(strCodePoint, 0, 2);
        System.out.println(s);
    }

    @Test
    public void getBytes() throws UnsupportedEncodingException {
        String str="赵";
        final byte[] bytes = str.getBytes("UTF-8");
        System.out.println(bytes);
    }

    @Test
    public void run3() {

    }

}
