package model;

public class StudentClass {

	String studentname;
	String studentnumber;
	
	public StudentClass() {
		System.out.println("default const");
	}
	
	public StudentClass(String studentname, String studentnumber) {
		super();
		System.out.println("para const");
		this.studentname = studentname;
		this.studentnumber = studentnumber;
	}
	public String getStudentname() {
		System.out.println("getStudentname");
		return studentname;
	}
	public void setStudentname(String studentname) {
		System.out.println("setStudentname");
		this.studentname = studentname;
	}
	public String getStudentnumber() {
		System.out.println("getStudentnumber");
		return studentnumber;
	}
	public void setStudentnumber(String studentnumber) {
		System.out.println("setStudentnumber");
		this.studentnumber = studentnumber;
	}
	
	
}
