package com.atguigu.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(2, 5,
                2L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 0; i<=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread()+"办理业务");

                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            threadPool.shutdown();
        }
    }



}
