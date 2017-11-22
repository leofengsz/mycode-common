package com.mycom.designpatterns.factory.factorymethod1;

public class NokiaFactory implements MobileFactory {
  public Mobile produceMobile() {
    return new Nokia();
  }
}
