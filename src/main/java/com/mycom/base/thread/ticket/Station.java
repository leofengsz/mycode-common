package com.mycom.base.thread.ticket;

public class Station extends Thread {
  
  private static int tick=20;
  
  //  创建一个静态钥匙
  private static Object objLock="aa";
  
  public Station(String name){
    super(name);
  }
  
  public void run(){
    while(tick > 0){
      synchronized(objLock){
        if(tick>0){
          System.out.println(this.getName() + "卖出了第" + tick + "张票");
          tick--;
        }else {
          System.out.println("票卖完了");
        }
      }
      try {
        sleep(1000);//休息一秒
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }
    
  }

}
