package chap15.exam02;

public class Student {
	public String studentNum;
	public String name;
	
	public Student(String studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {return target.studentNum.equals(studentNum);}
		else { return false;}
	}
}
