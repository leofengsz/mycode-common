package com.mycom.designpatterns.factory.factorymethod;

public class Customer {

  public static void main(String[] args) {
    FactoryBMW320 fty320 = new FactoryBMW320();
    BMW320 bmw320 = fty320.createBMW();
    
    FactoryBMW523 fty523 = new FactoryBMW523();
    BMW523 bmw523 = fty523.createBMW();

  }

}
