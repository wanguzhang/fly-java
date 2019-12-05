package com.fly.study.guava;

import com.google.common.collect.ImmutableList;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author 张攀钦
 * @date 2019-12-05-10:40
 * @description
 */
public class ImmutableListDemo {
    @Test
    public void run1() {
        ImmutableList<String> build = ImmutableList.<String>builder().addAll(Lists.list("1", "2")).build();
        System.out.println(build);
    }

}
