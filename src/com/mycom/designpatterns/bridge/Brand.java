package com.mycom.designpatterns.bridge;
/**
 * 品牌抽象类
 * @author CC
 *
 */
public abstract class Brand {  
    protected XGPhone xgPhone; // key  
    public Brand(XGPhone xgPhone) {  
        this.xgPhone = xgPhone;  
    }  
    public abstract void run();  
}  