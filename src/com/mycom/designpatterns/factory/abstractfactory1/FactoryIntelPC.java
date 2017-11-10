package com.mycom.designpatterns.factory.abstractfactory1;

public class FactoryIntelPC implements FactoryPC {

  @Override
  public HPPC createHPPC(String name) {
    return new IntelHP(name);
  }

  @Override
  public IBMPC createIBMPC(String name) {
    return new IntelIBM(name);
  }
  

}
