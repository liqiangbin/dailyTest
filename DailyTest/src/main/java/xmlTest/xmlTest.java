package xmlTest;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
@SuppressWarnings("restriction")
public class xmlTest {

	public static void main(String[] args) throws JAXBException {
	    xmlTest test=new xmlTest();
      Student stu=new Student();
      stu.setId("20123094");
      stu.setStuName("Bin");
      stu.setStuSex("男");
    String xml=test.beanToXml(stu);
    System.out.println("******************下面是obj转换为xml结果************************");
    System.out.println(xml);
    System.out.println("******************以下为xml转对象过程************************");
    Student student=new Student();
    student = xmlToBean(xml, Student.class);
    System.out.println("xml 转换位new student 结果：");
    System.out.println("student.getStuName()="+student.getStuName());
    System.out.println("student.getStuSex()="+student.getStuSex());
    
	}
	
/**
 * 对象转xml 
 * @param obj
 * @return xml
 * @throws JAXBException
 */
	public String beanToXml(Object obj) throws JAXBException{
		String xml="";
		  JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();   //Marshaller 类负责管理将 Java 内容树序列化回 XML 数据的过程
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串  
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式  
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 默认false表示xml指令存在   即是否包含 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			StringWriter writer = new StringWriter();
			jaxbMarshaller.marshal(obj, writer);
			xml=writer.toString();
		return xml;
	}
	
	/**
	 * 
	 * @param xml class
	 * @return  
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
			return t;
		} catch (Exception e) {
			System.out.println("转换出错");
			return t;
		}
	}
}
