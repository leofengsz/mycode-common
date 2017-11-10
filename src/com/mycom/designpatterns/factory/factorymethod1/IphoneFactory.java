package com.mycom.designpatterns.factory.factorymethod1;

public class IphoneFactory implements MobileFactory {
  public Mobile produceMobile() {
    return new Iphone();
  }
}
