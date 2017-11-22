package com.mycom.designpatterns.composite;

/**
 * 表示单个对象
 *
 */
public class Leaf extends Component {  
    public Leaf(String name) {  
        super(name);  
    }  
    @Override  
    public void add(Component c) {  
    }  
    @Override  
    public void remove(Component c) {  
    }  
    @Override  
    public void display(int depth) {  
        for (int i = 0; i < depth; i++) {  
            System.out.print("-");  
        }  
        System.out.println(name);  
    }  
  
}  