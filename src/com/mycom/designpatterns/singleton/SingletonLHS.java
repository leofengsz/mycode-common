package com.mycom.designpatterns.singleton;

/**
 * 单例模式 - 懒汉式
 * @author CC
 *
 */
public class SingletonLHS {
	
	private static SingletonLHS ms = null;
	
	private SingletonLHS(){
	}

	public static synchronized SingletonLHS getInstance(){
		if(ms==null){
			ms = new SingletonLHS();
		}
		return ms;
	}
	
	public void printtest(){
		System.out.println("懒汉式调用正常");
	}
}
