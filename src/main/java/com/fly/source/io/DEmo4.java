package com.fly.source.io;

import sun.misc.Launcher;

import java.io.IOException;

/**
 * @author 张攀钦
 * @date 2020-07-08-09:52
 */
public class DEmo4 {
    public static void main(String[] args) throws IOException {
        final ClassLoader classLoader = Launcher.getLauncher().getClassLoader();
        System.out.println(classLoader);
        System.out.println(Launcher.getBootstrapClassPath());
    }
}
