package com.mycom.designpatterns.factory.abstractfactory1;

public class IntelHP implements HPPC {
  
  private String name;
  
  public IntelHP(String name){
    this.name = name;
    System.out.println("创建一个英特尔处理器的惠普电脑");
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println("我是英特尔处理器的惠普电脑==="+name);

  }

}
