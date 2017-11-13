package com.mycom.designpatterns.observer;

/**
 * 具体观察者
 * @author CC
 *
 */
public class SleepObserver extends Observer {  
    public SleepObserver(String name) {  
        // TODO 自动生成的构造函数存根  
        super(name);  
    }  
    @Override  
    public void update() {  
        // TODO 自动生成的方法存根  
        System.out.println(name + ",老板回来了，别睡了");  
    }  
}  