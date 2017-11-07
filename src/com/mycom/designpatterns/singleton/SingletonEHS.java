package com.mycom.designpatterns.singleton;

/**
 * 单例模式 - 饿汉式
 * @author CC
 *
 */
public class SingletonEHS {
	
	private static final SingletonEHS ehs = new SingletonEHS();
	
	private SingletonEHS(){
		
	}
	
	public static SingletonEHS getInstance(){
		return ehs;
	}
	

	public void printtest(){
		System.out.println("饿汉式调用正常");
	}

}
