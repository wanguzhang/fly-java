package com.fly.study.java.generics;

/**
 * @author 张攀钦
 * @date 2019-09-16-07:42
 * @description
 */
public class TestServiceImpl implements TestService<String> {
    @Override
    public String getT(String t) {
        return t;
    }
}

class TestServiceImpl2<T> implements TestService<T> {

    @Override
    public T getT(T t) {
        return t;
    }
}

class TestServiceImpl3<T> implements TestService<String> {

    @Override
    public String getT(String s) {
        return null;
    }
}