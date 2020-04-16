package com.yedam.study;

public class Student extends Person {
	private String school;


	
	public Student() {
		super();
	}


	public Student(String name, int age, String school) {
		super(name,age);
		this.setSchool(school);
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	@Override
	public String toString() {
		return "Student [name =" + super.getName() + ",age=" + super.getAge() + ",학교는=" + "school=" + school + "]";
	}

}
