package com.atguigu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private  static  final  int NUMBER=7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(NUMBER,()->{
            System.out.println("集齐7颗龙珠可以召唤神龙");
        });
        for (int i = 0; i <=7 ; i++) {
            new Thread(
                    ()->{
                        System.out.println(Thread.currentThread().getName()+" 星龙被收集到了");

                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (BrokenBarrierException e) {
                            throw new RuntimeException(e);
                        }
                    },String.valueOf(i)
            ).start();
        }

    }



}
