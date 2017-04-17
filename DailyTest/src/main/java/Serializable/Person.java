package Serializable;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 序列化Id
	 */
	private static final long serialVersionUID = -9122096642444363706L;
	
	 private int age;
	 private String name;
     private String sex;
     
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
     
     
	

}
