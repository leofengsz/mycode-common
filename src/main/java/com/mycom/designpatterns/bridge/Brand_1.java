package com.mycom.designpatterns.bridge;
/**
 * 品牌继承类_1
 * @author CC
 *
 */
public class Brand_1 extends Brand {  
    public Brand_1(XGPhone xgPhone) {  
        super(xgPhone);  
    }  
    @Override  
    public void run() {  
        System.out.print(this);  
        xgPhone.run();  
    }  
    public String toString() {  
        return "品牌1的";  
    }  
} 