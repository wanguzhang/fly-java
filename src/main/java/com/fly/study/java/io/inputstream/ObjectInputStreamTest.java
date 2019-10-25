package com.fly.study.java.io.inputstream;

import cn.hutool.cache.impl.FIFOCache;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSON;
import com.fly.study.java.generics.ArgsParent;
import com.jfinal.json.Json;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2019-09-22-15:47
 * @description
 */
public class ObjectInputStreamTest {

    @Test
    public void run1() throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream =new FileOutputStream("object.tmp");
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        final ArgsParent argsParent = new ArgsParent();
        argsParent.setName("测试");
        objectOutputStream.writeObject(argsParent);
        FileInputStream fileInputStream =new FileInputStream("object.tmp");
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Object o = objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();
        objectOutputStream.close();
    }


}
