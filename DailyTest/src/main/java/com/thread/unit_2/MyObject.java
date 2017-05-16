package com.thread.unit_2;

public class MyObject {
	synchronized public void methodA(){
		try {
		    System.out.println("begin method A:"+Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
