package com.mycom.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体通知者
 * @author CC
 *
 */
public class SecretaryNotifier extends Notifier {
  
  private List<Observer> observers = new ArrayList<Observer>();

  @Override
  public void attach(Observer observer) {
    observers.add(observer);

  }

  @Override
  public void detach(Observer observer) {
    observers.remove(observer);

  }

  @Override
  public void notifyObservers() {
    for (Observer ob : observers) {
      System.out.print("秘书说：");
      ob.update();
    }

  }

}
