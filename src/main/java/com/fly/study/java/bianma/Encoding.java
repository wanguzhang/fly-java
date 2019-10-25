package com.fly.study.java.bianma;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2019-10-18-11:36
 * @description ucs-2 转换 utf
 */
public class Encoding {
    public static void main(String[] args) throws IOException {
        System.out.println(Paths.get("").toAbsolutePath());
        Path path = Paths.get("target/classes/uts-2.txt");
        InputStream inputStream = Files.newInputStream(path);
        String read2 = IoUtil.read(inputStream, StandardCharsets.UTF_16LE);
        System.out.println(read2);
    }

    @Test
    public void run1() throws UnsupportedEncodingException {
        String str = "字";
//        {-27,-83,-105,}
        byte[] bytes = str.getBytes();
        System.out.println(bytes.toString());
        String s = new String(bytes, "UTF-8");
        System.out.println(s);
    }

    @Test
    public void run2() throws UnsupportedEncodingException {
        String str = "字";
        // {-41,-42}
        System.out.println(toGBK(str));
    }

    public static String run3(String str, String charset) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(charset);
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (byte aByte : bytes) {
            sb.append(aByte).append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    public static String toUTF_8(String str) throws UnsupportedEncodingException {
        return run3(str, "UTF-8");
    }

    public static String toGBK(String str) throws UnsupportedEncodingException {
        return run3(str, "GBK");
    }

    @Test
    public void run4() throws UnsupportedEncodingException {
        String str = "严";
//        {-47,-49,}
        System.out.println(toGBK(str));
//        {-28,-72,-91,}
        System.out.println(toUTF_8(str));
    }

    @Test
    public void run44() {
        String str = "\u0c2c";
//        బ
        System.out.println(str);
//      ✈
        System.out.println("\u2708");
    }
}
