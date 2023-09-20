package com.atguigu.practice;

public class PrimeThread extends Thread{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
    }
}
