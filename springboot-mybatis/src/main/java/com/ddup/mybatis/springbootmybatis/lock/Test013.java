package com.ddup.mybatis.springbootmybatis.lock;

import java.util.concurrent.locks.LockSupport;

public class Test013 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("start");
            //阻塞当前线程
            LockSupport.park();//
            System.out.println("end");
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        t1.interrupt();
        System.out.println("主线程唤醒子线程");
        LockSupport.unpark(t1);
    }
}