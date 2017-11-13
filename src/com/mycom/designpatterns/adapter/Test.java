package com.mycom.designpatterns.adapter;
/**
 * 适配器模式(Adapter) 
 * 接口型模式
 * 
 * 1.适配器模式的宗旨是，保留现有类提供的服务，向客户提供接口，以满足客户的期望。
 * 2.使用一个已经存在的类，如果它的接口也就是方法和你的需求不同时，可以考虑用适配器模式。
 *
 */
public class Test {  
    public static void main(String[] args) {  
        Target target = new Adapter(); //通过适配器，此时调用的是适配的类的方法  
        target.request();  
    }  
}  