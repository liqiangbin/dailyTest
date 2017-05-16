package com.thread.unit_2;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyObject object=new MyObject();
		ThreadA a=new ThreadA(object);
		ThreadB b=new ThreadB(object);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();

	}

}
