package com.yedam.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



public class LambdaExpressionExample {
	public static void main(String[] args) {
		List<Student> list  = Arrays.asList(new Student("홍", 90), new Student("황",92));
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getscore();
			System.out.println(name + "-" + score);
		});
	}

}
