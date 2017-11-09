package com.mycom.designpatterns.factory.factorysimple;

public class Customer {

  public static void main(String[] args) {
    Factory fatory = new Factory();
    BMW bmw320 = fatory.createBMW(320);  
    BMW bmw523 = fatory.createBMW(523);
    
    bmw320.print();
    bmw523.print();

  }

}
