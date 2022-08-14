package com.ddup.mybatis.springbootmybatis.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                System.out.println("t1开始执行..");
                countDownLatch.await();
                System.out.println("t1结束执行..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        countDownLatch.countDown();
        System.out.println("主函数执行完成！");

    }
}
