package com.bin.shujujiegou;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DoString {
	/**
	 * 判断两个字符串是否由相同的字符组成
	 * 字母和字母个数都一样，顺序不同
	 * @param s1
	 * @param s2
	 */
	public static void sameChar(String s1,String s2){
		byte[] s1Char=s1.getBytes();
		byte[] s2Char=s2.getBytes();
		Arrays.sort(s1Char);
		Arrays.sort(s2Char);
		s1=new String(s1Char);
		s2=new String(s2Char);
		if(s1.equals(s2)){
			System.out.println("相同！");
		}else{
			System.out.println("不同！");
		}
	}

	public static void main(String[] args) {
		//测试字符串是否相同
		String  s1="aaabbb";
		String s2="ababab";
		sameChar(s1, s2);
		

	}

}
