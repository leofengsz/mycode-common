package com.mycom.designpatterns.adapter;
/**
 * 把客户接口转换成目标接口
 *
 */
public class Adapter extends Target{  
    private Adaptee adaptee = new Adaptee(); //封装一个Adaptee对象  
    public void request() {  
        adaptee.specialRequest();  
    }  
}  