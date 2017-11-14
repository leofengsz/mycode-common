package com.mycom.base.thread.ticket;

public class Test {

  public static void main(String[] args) {
    Station s1 = new Station("窗口1");
    Station s2 = new Station("窗口2");
    Station s3 = new Station("窗口3");
    s1.start();
    s2.start();
    s3.start();
  }

}
