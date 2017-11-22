package com.mycom.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;
/**
 * 表示对象组合
 *
 */
public class Composite extends Component {
  private List<Component> components = new ArrayList<Component>();

  public Composite(String name) {
    super(name);
  }

  @Override
  public void add(Component c) {
    components.add(c);
  }

  @Override
  public void remove(Component c) {
    components.remove(c);
  }

  @Override
  public void display(int depth) { // 区分单个对象和组合对象
    for (int i = 0; i < depth; i++) {
      System.out.print("-");
    }
    System.out.println(name);
    for (Component component : components) {
      component.display(depth + 2);
    }
  }

}
