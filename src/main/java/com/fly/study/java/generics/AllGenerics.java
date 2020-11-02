package com.fly.study.java.generics;


import org.junit.Test;

import java.lang.reflect.Method;


public class AllGenerics<T> {

    public <S extends ArgsParent> void run2(S s) {
        System.out.println(s);
    }

    public void run1(T t) {
        System.out.println(t);
    }

    @Test
    public void test1() throws Exception {
        AllGenerics<String> allGenerics =new AllGenerics<>();
        Method method= allGenerics.getClass().getMethod("run1", Object.class);
//        java.lang.NoSuchMethodException: com.fly.study.java.generics.AllGenerics.run1(java.lang.String)
//        Method method= allGenerics.getClass().getMethod("run1", String.class);
        method.invoke(allGenerics,"111");
    }

    @Test
    public void run2() throws Exception {
        AllGenerics<String> allGenerics =new AllGenerics<>();
        Method method= allGenerics.getClass().getMethod("run2", ArgsParent.class);
        ArgsParent argsParent = new ArgsParent();
        argsParent.setName("测试");
//        java.lang.NoSuchMethodException: com.fly.study.java.generics.AllGenerics.run1(java.lang.String)
//        Method method= allGenerics.getClass().getMethod("run2", Object.class);
        method.invoke(allGenerics,argsParent);
    }

}