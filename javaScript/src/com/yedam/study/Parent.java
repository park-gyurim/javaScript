package com.yedam.study;

interface EmpService {
	void getEmployee(int empId);
}
//class Child extends Parent {
//	int age;
//	int getAge() {
//		return age;
//	}
//	@Override
//	String getName() {
//		// TODO Auto-generated method stub
//		return super.getName() + ", age: " + this.age;
//	}
//	
//	
//}

public class Parent {
	String name;
	String getName() {
		return name;
	}

}
