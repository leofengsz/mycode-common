package com.mycom.designpatterns.observer;

public class NBAObserver extends Observer {
  
  public NBAObserver(String name){
    super(name);
  }

  @Override
  public void update() {
    System.out.println(name + ",老板回来了，别看NBA了");  

  }

}
