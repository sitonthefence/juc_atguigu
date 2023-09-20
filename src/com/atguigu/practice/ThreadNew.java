package com.atguigu.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable <Integer>{
    @Override
    public Integer call() throws Exception {
        int sum =0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew{
    public static void main(String[] args) {
        NumThread numThread=new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        new Thread(futureTask).start();
        try {
            Integer sum = futureTask.get();
            System.out.println(
                    "总和为"+sum
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }



}
