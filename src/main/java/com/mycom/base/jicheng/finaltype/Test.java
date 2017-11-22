package com.mycom.base.jicheng.finaltype;

public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String username = "liufeng";
    AA a = new AA();
    System.out.println(username.hashCode());
    a.fun(username);
    System.out.println(username.hashCode());
    String ttt = username.concat("");
    System.out.println(ttt.hashCode());
    System.out.println("main === "+ttt);
    username = username+"eee";
    System.out.println(username.hashCode());
    System.out.println("main === "+username);
    

  }

}

class AA{
  public void fun(final String username){
    System.out.println("AA === "+username);
  }
}
