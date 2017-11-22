package com.mycom.designpatterns.observer;

/**
 * 抽象观察者
 * @author CC
 *
 */
public abstract class Observer {
  
  protected String name;
  
  public abstract void update();
  
  public Observer(String name){
    this.name = name;
  }

}
