package com.mycom.designpatterns.observer;

/**
 * 1.观察者模式的宗旨是在多个对象之间定义一对多的关系，以便当一个对象状态改变的时候，
 * 其他所有依赖于这个对象的对象都能够得到通知，并自动更新。
 * 2.观察者模式又叫做发布-订阅模式，定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
 *
 */
public class Test {  
    public static void main(String[] args) {  
        Notifier notifier = new SecretaryNotifier();  
        Observer observer = new SleepObserver("小明");  
        Observer observer2 = new SleepObserver("小东");  
        Observer observer3 = new NBAObserver("小强");  
        notifier.attach(observer);  
        notifier.attach(observer2);  
        notifier.attach(observer3);  
        notifier.notifyObservers(); // 一次更新所有  
    }  
}  