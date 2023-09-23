package com.atguigu.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo1 {
    public static void main(String[] args) {

        ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
        writeLock.lock();
        System.out.println("atguigu");
         readLock.lock();
        System.out.println("---read");
       writeLock.unlock();
        readLock.unlock();
    }




}
