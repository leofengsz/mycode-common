package com.mycom.designpatterns.factory.abstractfactory1;

public class FactoryAmdPC implements FactoryPC {

  @Override
  public HPPC createHPPC(String name) {
    return new AmdHP(name);
  }

  @Override
  public IBMPC createIBMPC(String name) {
    return new AmdIBM(name);
  }
  

}
