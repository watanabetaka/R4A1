package bean;
import java.sql.Date;

public class Student implements java.io.Serializable {

	private int studentId;
	private String name,depart;
	private Date birthday;

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getDepartment() {
		return depart;
	}

        

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthday(Date birthday) {
		this. birthday =  birthday;
	}

	public void setDepartment(String depart) {
		this.depart = depart;
	}


}