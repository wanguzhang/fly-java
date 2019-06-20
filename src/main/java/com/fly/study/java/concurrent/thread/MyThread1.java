package com.fly.study.java.concurrent.thread;

/**
 * @author 张攀钦
 * @date 2019-06-20-06:57
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new MyThread1().start();
        }
    }
}
