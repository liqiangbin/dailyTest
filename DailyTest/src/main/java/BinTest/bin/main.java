package BinTest.bin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;


public class main {

	public static void main(String[] args) throws Exception {
		System.out.println("对象转json:");
		Student student = new Student();
		student.setId("1");
		student.setName("zhangsan");
		student.setAge("12");
		student.setSex("男");
		JSONObject json = JSONObject.fromObject(student);
		System.out.println("对象转json结果：" + json.toString());
		System.out.println("");
		System.out.println("根据json转成相应对象Start:");
		String jsonString = json.toString();
		JSONObject json1 = JSONObject.fromObject(json.toString());
		Student s = new Student();
		s = (Student) JSONObject.toBean(json1, Student.class);
		System.out.println(s.getAge() + "|" + s.getName());
		System.out.println("");
		System.out.println("对象转map:");
		Map map = new HashMap<String, String>();
		map = ObjToMap(s);
		System.out.println("对象转换的map结果：" + map.get("name"));
		System.out.println("对象转换的map结果：" + map.toString());
		System.out.println("");

		System.out.println("map转xml:");
		String xml = toXml(map);
		System.out.println("map 转换的xml结果：" + xml);
		System.out.println("");

		System.out.println("xml遍历解析：");
		String xmlString=xml;
		showXml(xmlString);
	}

	/**
	 * 
	 * @param 对象
	 * @return 需要的map
	 * @throws Exception
	 */
	public static Map ObjToMap(Object e) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Class cls = e.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			map.put(f.getName(), (String) f.get(e));
		}
		return map;
	}

	/**
	 * 转xml
	 * 
	 * @param params
	 * @return
	 */
	public static String toXml(Map<String, String> params) {
		StringBuilder buf = new StringBuilder();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		buf.append("<xml>");
		for (String key : keys) {
			if (!"".equals(params.get(key))) {
				buf.append("<").append(key).append(">");
				buf.append(params.get(key));
				buf.append("</").append(key).append(">\n");
			}

		}
		buf.append("</xml>");
		return buf.toString();
	}
	
	
/**
 * 
 * @param xml
 * @throws DocumentException
 * 
 * 
 * 如果遍历如下格式xml 
 * <xml><param name=age>12</age>
<param name=id>1</id>
<param name=name>zhangsan</name>
<param name=sex>男</sex>
</xml>

则采用如下方法遍历

List<Element> params = root.elements("param");
	 for (Element param : params) {
		 if ("sign".equals(param.attribute("name").getStringValue())) {
			 alipaySign = param.getStringValue();
		 }
	 }


 */
	public static void showXml(String xml) throws DocumentException {
		Document document = null;
		document = DocumentHelper.parseText(xml);
		 Element root = document.getRootElement();
		List<Element> list =root.elements();
		System.out.println("传入的xml解析结果如下：");
		for (Element e : list) {
			System.out.println("name:"+e.getName()+"| value:"+e.getStringValue());
		}
	}

}
