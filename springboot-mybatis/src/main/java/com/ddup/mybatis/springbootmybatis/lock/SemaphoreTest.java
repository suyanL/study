package com.ddup.mybatis.springbootmybatis.lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));
        //信号总数为5
        Semaphore semaphore = new Semaphore(5);
        //运行10个线程
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        //获取信号
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
                        //阻塞2秒，测试效果
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //释放信号
                        semaphore.release();
                    }

                }
            });
        }
        threadPool.shutdown();
    }
}
