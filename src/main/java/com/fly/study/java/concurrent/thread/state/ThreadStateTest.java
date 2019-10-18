package com.fly.study.java.concurrent.thread.state;

/**
 * @author 张攀钦
 * @date 2019-10-10-14:52
 * @description 线程状态验证
 */
public class ThreadStateTest {

    private static final Object OBJECT = new Object();

    public static void main(String[] args) {

        Thread thread0 = new Thread(() -> {
            synchronized (OBJECT) {
                try {
                    OBJECT.notifyAll();
                    System.out.println("thread-0-wait 之前");
                    Thread.sleep(10000);
//                    OBJECT.wait(5000);
//                    System.out.println("thread-0-wait 之后");
//                    OBJECT.notifyAll();
                } catch (Exception e) {

                }
            }

        });

        Thread thread1 = new Thread(() -> {
            synchronized (OBJECT) {
                try {
                    OBJECT.notifyAll();
                    System.out.println("thread-1-wait 之前");
                    OBJECT.wait(5000);
                    System.out.println("thread-1-wait 之后");
                    OBJECT.notifyAll();
                } catch (Exception e) {

                }
            }
        });
        thread0.start();
        thread1.start();
    }
}

