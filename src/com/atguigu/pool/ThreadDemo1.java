package com.atguigu.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo1 {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool3 = Executors.newCachedThreadPool();


        try {
            for (int i = 0; i<=1000; i++) {
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread()+"办理业务");

                });

            }

        } catch (Exception e) {
         e.printStackTrace();
        } finally {

            threadPool1.shutdown();
        }

    }
}
