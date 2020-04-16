package com.yedam.study;

import java.util.List;

public class Sample {
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}

	public static void main(String[] args) {
		StudentService service = new StudentServiceImpl();
		List<Student> list= service.getStudList();
		for( Student s:list) {
			System.out.println(s.toString());
		service.getStudList();
			
		}
		
//		Person p1 = new Person();
//		p1.setName("park");
//		p1.setAge(20);
//		String n = p1.getName();
//		int a = p1.getAge();
//		Person p2 = new Person("king", 20);
//		System.out.println(p2.getName() + "," + p2.getAge());
//
//		Student s1 = new Student();

	}

}
