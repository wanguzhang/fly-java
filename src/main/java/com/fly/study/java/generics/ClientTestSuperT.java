package com.fly.study.java.generics;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-09-16-07:34
 * @description 泛型擦除验证
 */
@Data
public class ClientTestSuperT {
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String>t=new ArrayList<>();
        Method add = t.getClass().getMethod("add",Object.class);
        add.invoke(t,1);
        System.out.println(t);
    }

    @Test
    public void test2() throws Exception {
        ListExtendsTest<ArgsSon> t= new ListExtendsTest<>();
        Method add = t.getClass().getMethod("log",ArgsParent.class);
        System.out.println(add.getName());
    }
}

@Data
class ListExtendsTest<T extends ArgsParent>{
    public void log(T t){
        System.out.println(t.getClass().getName());
        System.out.println(t.getName());
    }
}