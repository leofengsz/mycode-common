package com.mycom.designpatterns.bridge;
/**
 * 
1.桥接模式的意图是将抽象与抽象方法的实现相互分离，这样它们就可以独自变化。
2.将抽象部分与它的实现部分分离，使它们可以独自变化。
3.实现系统有多角度分类，每一种分类都可能变化，那么就把这种多角度分离出来让它们独自变化，减少它们之间的耦合性。
假设一颗继承树如下：
--手机
----手机品牌A
------2G手机品牌A
------3G手机品牌A
------4G手机品牌A
----手机品牌B
------2G手机品牌B
......
上面这种模式如果每增加一个手机品牌或者出产一种新的5G、6G手机都会造成很高的耦合。使用桥接模式可以很好地解耦：
 *
 */
public class Test {  
    public static void main(String[] args) {  
        // TODO 自动生成的方法存根  
        Brand brand1 = new Brand_1(new X2GPhone());  
        brand1.run();  
    }  
  
}  