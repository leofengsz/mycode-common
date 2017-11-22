package com.mycom.designpatterns.factory.factorymethod;

public class FactoryBMW320 implements FactoryBMW {

  @Override
  public BMW createBMW() {
    return new BMW320();
  }

}
