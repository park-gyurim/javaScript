package com.yedam.lambda;

@FunctionalInterface
interface MyInterface1<T> {
	void get(T t);
}

@FunctionalInterface
interface MyInterface2 {
	String get(String str, String str1);
}

interface Consumer<T> {
	void get(T t);
}

class Students {
	String name;
	int age;

	Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void getInfo() {
		System.out.println("Name: " + this.name + ", Age: " + this.age);
	}
}
//class ConsumerClass<T> implements Consumer<T> {
//
//	@Override
//	public void get(T t) {
//		
//	}
//}

//class MyInterClass implements MyInterface1 {
//	@Override
//	public void get() {
//		System.out.println("hello");
//	}
//}
public class BasicExample2 {
	public static void main(String[] args) {

		Consumer<String> mi3 = (t) -> {
			System.out.println("hello" + t);
		};
		mi3.get("ddd");
	}
}

//		MyInterface1<Student> mi = (Student s) -> {
//			System.out.println("hello" + s);
//			
//		};
//		Student st = new Student();
//		mi.get(st);
//		
//		MyInterface2 mi2 = new MyInterface2() {
//			@Override
//			public String get(String str, String str1) {
//				return str.concat(str1);
//				//str + str1
//			}
//	};
//}
