package com.atguigu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int flag=1;
    private Lock lock=new ReentrantLock();

    private Condition conditionA=lock.newCondition();

    private Condition conditionB=lock.newCondition();

    private Condition conditionC=lock.newCondition();

    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1){
                conditionA.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println("第"+loop+"次循环,AA打印第"+i+"次");
            }
            flag=2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }


    }
    public void print10(int loop)throws InterruptedException{

        lock.lock();
        try {
            while (flag!=2){
                conditionB.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println("第"+loop+"次循环,BB打印第"+i+"次");
            }
            flag=3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }

    }
    public void print15(int loop)throws InterruptedException{

        lock.lock();
        try {
            while (flag!=3){
                conditionC.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println("第"+loop+"次循环,CC打印第"+i+"次");
            }
            flag=1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }

    }


}
public class ThreadDemo3 {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"AA"
        ).start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"BB"
        ).start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"CC"
        ).start();
    }



}
