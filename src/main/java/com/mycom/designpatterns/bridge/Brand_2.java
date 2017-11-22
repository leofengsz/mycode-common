package com.mycom.designpatterns.bridge;
/**
 * 品牌继承类_2
 * @author CC
 *
 */
public class Brand_2 extends Brand {  
    public Brand_2(XGPhone xgPhone) {  
        super(xgPhone);  
    }  
    @Override  
    public void run() {  
        System.out.print(this);  
        xgPhone.run();  
    }  
    public String toString() {  
        return "品牌2的";  
    }  
} 