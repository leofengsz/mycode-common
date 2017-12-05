package com.mycom.base.myenum;

public class Test {

  public static void main(String[] args) {
        MyColor color = MyColor.RED;
        switch(color){
          case RED: System.out.println("RED");break;
          case BLACK: System.out.println("BLACK");break;
          case YELLOW: System.out.println("YELLOW");break;
          default:System.out.println("default");break;
        }
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
  }

}
