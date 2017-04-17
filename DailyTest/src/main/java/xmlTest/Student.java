package xmlTest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Student")
public class Student {
	@XmlElement(name = "StuID")
	private String Id;
	@XmlElement(name = "StuName")
	private String StuName;
	@XmlElement(name = "StuSex")
	private String StuSex;
	@XmlElement(name = "Grade")
	private String Grade;
	public String getId() {
		return Id;
	}
	public String getStuName() {
		return StuName;
	}
	public String getStuSex() {
		return StuSex;
	}
	public void setId(String id) {
		Id = id;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public void setStuSex(String stuSex) {
		StuSex = stuSex;
	}

}
