package com.bin.shujujiegou;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 测试了对比了list 和set区别，并利用反射机制加载类进行处理
 * @author admin
 *
 */
public class ListAndSetTest {
	 String string[]={"i","am","xiao","huang","am"}; 
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<?> cla=Class.forName("com.bin.shujujiegou.ListAndSetTest");
		Object obj=cla.newInstance();
		Method setList=cla.getMethod("setList");
		setList.invoke(obj);
		Method setSet=cla.getMethod("setSet",int.class,String.class);//这里后面参数表示方法的参数类型
		setSet.invoke(obj,0, "123");
	}
	
	public void setList(){
		 List<String> list=new ArrayList<String>();
		 for (String s:string) {
			 list.add(s);
		}
		 for (String string2 : list) {
			System.out.println("list结果："+string2);
		}
	}
	
	
	public void setSet(int k,String ss){
		System.out.println("mm="+ss);
		Set<String> set=new HashSet<String>();
		 for (String s:string) {
			 set.add(s);
		}
		 java.util.Iterator<String> iterator= set.iterator();
		 while(iterator.hasNext()){  
	            System.out.println("set的输出结果是："+iterator.next());  
	        }  
		
	}
	
}
