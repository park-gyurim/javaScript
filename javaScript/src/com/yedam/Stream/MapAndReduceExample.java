package com.yedam.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduceExample {
	public static void main(String[] args) {
	List<Student> list = Arrays.asList(new Student("홍",90), new Student("황",92),new Student("박",92));
	double avg = list.stream()
			.mapToInt((Student s) -> {
				return s.getScore();
			})
			.average()
			.getAsDouble();
	
	Stream<Student>	stream = list.stream();
	IntStream intStream = stream.mapToInt((Student s) -> {
		return s.getScore();
	});
	OptionalDouble odb1 = intStream.average();
	avg = odb1.getAsDouble();
			System.out.println(avg);
			
}
}
