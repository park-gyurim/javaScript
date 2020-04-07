package com.yedam.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Student {
	String name;
	int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

}

public class LambdaExpressionExample {
	public static void main(String[] args) {
		List<Student> list  = Arrays.asList(new Student("홍", 90), new Student("황",92));
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});
	}

}
