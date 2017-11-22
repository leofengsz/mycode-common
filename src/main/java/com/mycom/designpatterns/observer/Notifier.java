package com.mycom.designpatterns.observer;

/**
 * 抽象通知者
 * @author CC
 *
 */
public abstract class Notifier {
  
  public abstract void attach(Observer observer);
  public abstract void detach(Observer observer);
  public abstract void notifyObservers();

}
