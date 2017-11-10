package com.mycom.designpatterns.factory.factorymethod;

public class FactoryBMW523 implements FactoryBMW {

  @Override
  public BMW createBMW() {
    return new BMW523();
  }

}
