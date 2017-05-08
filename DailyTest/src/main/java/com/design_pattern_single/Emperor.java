package com.design_pattern_single;

public class Emperor {
	private static final Emperor emperor=new Emperor();
	private Emperor(){
		//构造函数private 化
	}

	public static Emperor getInstance(){
		return emperor;
	}
	public static void say(){
		System.out.println("我是皇帝1");
	}
}
