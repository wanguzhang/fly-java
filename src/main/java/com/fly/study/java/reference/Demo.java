package com.fly.study.java.reference;

import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void run3() {
        ArrayList<MyDemo1> objects = Lists.newArrayList();
        MyDemo1 myDemo1=null;
        for (int i = 0; i < 5; i++) {
            myDemo1=new MyDemo1();
            myDemo1.setName(String.valueOf(i));
            objects.add(myDemo1);
        }
        System.out.println(objects);
    }
}

@Data
class MyDemo1{
    private String name;
}