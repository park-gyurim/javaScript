package com.yedam.collection;

public class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
		// TODO Auto-generated method stub
//		if (this.age > o.age) {
//			return 1;
//
//		}else if (this.age < o.age) {
//			return -1;
//		}else {
//			return 0;
//		}
	}

}
