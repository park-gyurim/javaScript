package com.yedam.Stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", 10, Student.Gender.MALE),
				new Student("Kong", 9, Student.Gender.FEMALE),
				new Student("Wang", 8, Student.Gender.MALE),
				new Student("Tung", 7, Student.Gender.FEMALE)
				);
		List<Student> maleStudent = list.stream()
			.filter(s -> s.getGender() == Student.Gender.MALE)
			.collect(Collectors.toList());
		maleStudent.stream().forEach(s ->s.getName());
		
		Set<Student> femaleSet = list.stream()
				.filter(s-> s.getGender() == Student.Gender.FEMALE)
				.collect(Collectors.toSet());
		femaleSet.parallelStream().forEach(s -> System.out.println(s.getName()));
		HashSet<Student> hashSet = list.stream()
			.filter(s -> s.getscore() >= 9)
			.collect(Collectors.toCollection(() -> new HashSet<Student>()));
	}

}
