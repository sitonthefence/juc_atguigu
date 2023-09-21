package com.atguigu.sync;
class Share{
    private int number=0;

    public synchronized void incr() throws InterruptedException {
          if(number!=0){
              this.wait();
          }

              number++;
              System.out.println(Thread.currentThread().getName()+"::"+number);
              this.notifyAll();

    }
    public synchronized void decr() throws InterruptedException {
    if(number!=1){
        this.wait();
    }
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        this.notifyAll();

    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        Share share=new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }
}
