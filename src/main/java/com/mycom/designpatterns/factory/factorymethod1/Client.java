package com.mycom.designpatterns.factory.factorymethod1;

public class Client {
  public static void main(String[] args) {
    MobileFactory mbf = new NokiaFactory();
    Mobile mb = mbf.produceMobile();
    mb.call();
    mbf = new IphoneFactory();
    mb = mbf.produceMobile();
    mb.call();
  }
}
