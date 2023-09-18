package com.atguigu.sync;
class  Ticket{

    private int number=30;
    private synchronized void  sale(){

    if(number>0){
        System.out.println(Thread.currentThread().getName()+"卖出："+(number--)+"剩下"+number);
    }

    }

        }
public class SaleTicket {
    public static void main(String[] args) {

    }

}
