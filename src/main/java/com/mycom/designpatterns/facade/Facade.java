package com.mycom.designpatterns.facade;
/**
 * 外观类，对子系统的属性或方法进行组合，以备外界调用
 *
 */
public class Facade {  
    private Step step1 = new StepOne();  
    private Step step2 = new StepTwo();  
    private Step step3 = new StepThree();  
    public void step() {  
        step1.step();  
        step2.step();  
        step3.step();  
    }  
}