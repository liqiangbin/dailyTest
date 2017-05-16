package com.design_pattern_single;

public class ministerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			Emperor emperor=Emperor.getInstance();
			emperor.say();
		}

	}

}
