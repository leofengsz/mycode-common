package com.mycom.designpatterns.composite;
/**
 * 组合模式(Composite)
 * 接口类型模式
 * 
 * 1.组合模式的设计意图在于：让用户能够用统一的接口处理单个对象以及对象组合
 * 2.将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象使用具有一致性
 * 3.需求中是体现部分与整体层次结构，希望用户可以忽略组合对象与单个对象的不同，统一地使用组合结构中的所有对象。
 *
 */
public class Test {  
    public static void main(String[] args) {  
        Composite root = new Composite("root");  
        root.add(new Leaf("leaf1")); 
        
        Composite branch1 = new Composite("branch1");  
        branch1.add(new Leaf("leaf2")); 
        
        Composite branch2 = new Composite("branch2");  
        branch2.add(new Leaf("leaf3"));  
        branch2.add(new Leaf("leaf4"));  
        
        branch1.add(branch2);  
        
        root.add(branch1);  
        
        root.display(1);  
    }  
}  