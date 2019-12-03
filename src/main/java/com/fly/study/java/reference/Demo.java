package com.fly.study.java.reference;

import org.junit.Test;

/**
 * @author 张攀钦
 * @date 2019-12-03-16:06
 * @description ReferenceDemo
 */
public class Demo {

    @Test
    public void run() {
//        引用数据类型，引用地址传递
        Object a = new Object();
        Object b = a;
        System.out.println(a);
        System.out.println(b);
        a = new Object();
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void run2() {
        /**
         * 值传递，基本数据类型
         */

        int a = 0;
        int b = a;
        System.out.println(a);
        System.out.println(b);

        a = 2;
        System.out.println(a);
        System.out.println(b);
    }

}
