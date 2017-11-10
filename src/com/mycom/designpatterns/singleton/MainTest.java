package com.mycom.designpatterns.singleton;


public class MainTest {

	public static void main(String[] args) {
		/**
		 * 优点：
		 * 1. 提供唯一实例，控制对其访问，实现共享概念。
		 * 2. 节约资源，提高性能（针对频繁创建和销毁的对象）。
		 * 3. 允许可变数目的实例。
		 * 
		 * 缺点：
		 * 1. 没有抽象层，扩展性差。
		 * 2. 职责过重。
		 * 3. 由于JVM自动回收，可能导致状态丢失。
		 */
		SingletonLHS.getInstance().printtest();
		SingletonEHS.getInstance().printtest();
		
	}

}
