package com.ddup.mybatis.springbootmybatis.lock;

import java.util.concurrent.locks.LockSupport;

public class Test012 {

    private static Object lockObject = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockObject) {
                try {
                    System.out.println("start");
                    lockObject.wait();
                    System.out.println("end");
                } catch (Exception e) {

                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println("notify");
        synchronized (lockObject) {
            lockObject.notify();
        }
    }
}