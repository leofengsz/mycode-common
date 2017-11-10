package com.mycom.designpatterns.factory.abstractfactory1;

public class IntelIBM implements IBMPC {
  
  private String name;
  
  public IntelIBM(String name){
    this.name = name;
    System.out.println("创建一个英特尔处理器的IBM电脑");
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println("我是英特尔处理器的IBM电脑==="+name);

  }

}
