package com.thread.unit_2;

public class ThreadB extends Thread {
	private MyObject object;
	public ThreadB(MyObject object){
		super();
		this.object=object;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		object.methodA();
	}

}
