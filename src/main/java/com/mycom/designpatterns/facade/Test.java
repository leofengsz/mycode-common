package com.mycom.designpatterns.facade;
/**
 * 外观模式(Facade)
 * 接口类型模式
 * 1.外观模式的目的在于提供一个接口，使子系统更加容易使用
 * 2.为子系统的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * 3.外观模式为设计粗糙或高度复杂的遗留代码(即子系统)提供一个简单的接口，使新系统与Facade对象交互。
 *
 */
public class Test {  
    public static void main(String[] args) {  
        // Step step1 = new StepOne();  
        // Step step2 = new StepTwo();  
        // Step step3 = new StepThree();  
        // step1.step();  
        // step2.step();  
        // step3.step();  
        Facade facade = new Facade(); //通过外观类的组装，使子系统更加容易使用  
        facade.step();  
    }  
}  