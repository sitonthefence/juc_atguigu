package com.atguigu.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class MyCache{
  private volatile Map<String,Object> map=new HashMap<>();
  public void put(String key,Object value){
      System.out.println(Thread.currentThread().getName()+"正在写操作"+key);
      try {
          TimeUnit.MILLISECONDS.sleep(300);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      map.put(key, value);
      System.out.println(Thread.currentThread().getName()+"写完了"+key);
  }
  public Object get(String key){
      Object result=null;
      System.out.println(Thread.currentThread().getName()+"正在读取操作"+key);
      try {
          TimeUnit.MILLISECONDS.sleep(300);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      result=map.get(key);
      System.out.println(Thread.currentThread().getName()+"取完了"+key);
      return result;
  }


}
public class ReadWriteLockDemo {


}
