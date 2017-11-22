package com.mycom.designpatterns.factory.abstractfactory1;

public class AmdIBM implements IBMPC {
  

  private String name;
  
  public AmdIBM(String name){
    this.name = name;
    System.out.println("创建一个AMD处理器的IBM电脑");
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println("我是AMD处理器的IBM电脑==="+name);

  }

}
