package com.mycom.designpatterns.factory.abstractfactory1;

public class AmdHP implements HPPC {
  

  private String name;
  
  public AmdHP(String name){
    this.name = name;
    System.out.println("创建一个AMD处理器的惠普电脑");
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }

  @Override
  public void printName() {
    System.out.println("我是AMD处理器的惠普电脑==="+name);

  }

}
