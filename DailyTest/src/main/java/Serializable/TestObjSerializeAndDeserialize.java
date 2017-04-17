package Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

public class TestObjSerializeAndDeserialize {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//      SerializePerson();
      Person person=DeserializePerson();
      System.out.println(MessageFormat.format("name:{0},age={1},sex={2}", person.getName(),person.getAge(),person.getSex()));
		
	}

	@SuppressWarnings("unused")
	private static void SerializePerson() throws FileNotFoundException, IOException {
		Person person = new Person();
		person.setName("gacl");
		person.setAge(25);
		person.setSex("男");
		ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
	    oo.writeObject(person);
	    System.out.println("Person 对象序列化成功！");
	    oo.close();
	}
	
	@SuppressWarnings("unused")
	private static Person DeserializePerson() throws FileNotFoundException, IOException, ClassNotFoundException{
		Person person=new Person();
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
	    person=(Person) in.readObject();
		System.out.println("Person 反序列化成功！");
	    in.close();
		return person;
	}

}
