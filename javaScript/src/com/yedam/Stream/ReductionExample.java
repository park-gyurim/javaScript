package com.yedam.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("김", 92),
											new Student("이", 95),
											new Student("박", 88));
		// Student.getScore(int) sum() 집계결과를 가져옴.
		int sum = list.stream().mapToInt( s -> s.getscore() ).sum();
		
		// Student.getScore(int) reduce()
		OptionalInt oi = list.stream()
							.mapToInt( s -> s.getscore() )
							.reduce( (a,b) -> a+b );
		
		if(oi.isPresent()) {
			System.out.println(oi.getAsInt());
		}
		
		// Student.getScore(int) reduce(0, 결과값)
		int result = list.stream()
					.mapToInt( s->s.getscore() )
					.reduce(0, (a,b) -> a+b );
		System.out.println(result);
	}
}