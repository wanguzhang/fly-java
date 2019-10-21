package com.fly.study.java.bianma;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.IoUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//        UTF-8
        System.out.println(System.getProperty("file.encoding"));
//     {-47,-49,}
        System.out.println(toGBK("严"));

//    {-28,-72,-91,}
        System.out.println(toUTF_8("严"));
    }

    @Test
    public void run43() throws UnsupportedEncodingException {

//      {-28,-72,-108,}
//
        System.out.println(toUTF_8("且"));
    }


    @Test
    public void run45() throws UnsupportedEncodingException {
//        {-24,-75,-75,}
        System.out.println(toUTF_8("赵"));
    }

    @Test
    public void run454() throws UnsupportedEncodingException {
        String str ="赵";
        final byte[] bytes = str.getBytes("UTF-8");
        StringBuilder stringBuilder =new StringBuilder();

        for (byte aByte : bytes) {
            stringBuilder.append(aByte).append(",");
        }

        System.out.println(stringBuilder.toString());
    }


    @Test
    public void run99() throws UnsupportedEncodingException {
        byte[] bytes={-28,-72,-91};
        final String s = new String(bytes, "utf-8");
        System.out.println(s);
    }

    @Test
    public void run5() throws UnsupportedEncodingException {
//     {65,}
        System.out.println(toGBK("A"));

//    {65,}
        System.out.println(toUTF_8("A"));
    }

    @Test
    public void run55() {
        String str="严";
        final IntStream intStream = str.codePoints();
        final int[] ints = intStream.toArray();
        System.out.println(Stream.of(ints).map(String::valueOf).collect(Collectors.joining(",")));
    }

    @Test
    public void run66() throws UnsupportedEncodingException {
        String str = "张";
        final byte[] gbks = str.getBytes("GBK");
        final byte[] gbks1 = new String(gbks, "GBK").getBytes("UTF-8");
        final String s = new String(gbks1, "UTF-8");
        System.out.println(s);
    }

    @Test
    public void run77() throws IOException {
        Path path = Paths.get("target/classes/gbk.txt");
        InputStream inputStream = Files.newInputStream(path);
        final byte[] bytes = IoUtil.readBytes(inputStream);
        System.out.println(new String(bytes,"GBK"));
    }

    @Test
    public void run88() throws UnsupportedEncodingException {
        String s = "Hello World";
//      72 101 108 108 111 32 87 111 114 108 100
        byte[] arr = s.getBytes("UTF-8");
    }

    @Test
    public void run100() throws UnsupportedEncodingException {
        String str = "张";
        final byte[] gbks = str.getBytes("GBK");
        final String gbk = new String(gbks, "GBK");
        final byte[] bytes = gbk.getBytes("UTF-8");
        System.out.println(new String(bytes, "UTF-8"));
    }
}
