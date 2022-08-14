package com.ddup.mybatis.springbootmybatis.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test14 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ":1");
                condition.await();
                System.out.println(Thread.currentThread().getName() + ":2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        lock.lock();
        // 唤醒
        condition.signal();
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + ":3");

    }

}
