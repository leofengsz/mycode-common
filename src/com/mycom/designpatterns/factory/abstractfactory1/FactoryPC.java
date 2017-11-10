package com.mycom.designpatterns.factory.abstractfactory1;

public interface FactoryPC {
  
  public HPPC createHPPC(String name);
  public IBMPC createIBMPC(String name);
  
}
