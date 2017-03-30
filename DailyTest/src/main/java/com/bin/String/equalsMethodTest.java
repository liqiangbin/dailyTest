package com.bin.String;

public class equalsMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1=new String("sss");
		String s2=new String("sss");
		String s3="sss";
		System.out.println("Method:"+s1==s2);
		System.out.println("equals Method:"+s1.equals(s2));
		
		/**
		 * 得出结论：
		 * 
		 * 对于object类的equals（）方法，判断调用该方法的对象与要比较的对象是不是同一个对象（判断地址），
		 * 而String类中的equals()方法，则判断当前字符串与传递进来的字符串的内容是否一致。
		 * 
		 * 
		 * 对于一个object类，如果没有重写equals方法，默认都比较是否是同一个对象，
		 * 也就是说只要用关键字new生成的对象，就会返回false
		 */

	}
	
	
	/*
	 * equals:源码分析
	 * public boolean equals(Object anObject)
	{
	       //如果是同一个对象
	        if (this == anObject)
	        {
	            return true;
	        }
	        //如果传递进来的参数是String类的实例
	        if (anObject instanceof String)
	        {
	            String anotherString = (String)anObject;
	            int n = count;//字符串长度
	            if (n == anotherString.count) //如果长度相等就进行比较
	            {
	                char v1[] = value;//取每一个位置的字符
	                char v2[] = anotherString.value;
	                int i = offset;
	                int j = anotherString.offset;
	                while (n-- != 0) //对于每一位置逐一比较
	                {
	                    if (v1[i++] != v2[j++])
	                        return false;
	                }
	                return true;
	            }
	        }
	        return false;
	}
*/
}
