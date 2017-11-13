package com.mycom.base.threed;

public class ThreedTest1 extends Thread {
	
	public void run(){
		try {
			for(int i=1;i<10;i++){
				System.out.println(Math.random());
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
