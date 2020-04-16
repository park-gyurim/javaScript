package com.yedam.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduceExample { //컬렉션(List<T>)로 부터 스트림 얻기
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 58), 
				new Student("신용권", 47),
				new Student("유미선", 66));
		// list.stream().mapToInt(s -> s.getscore()).average().getAsDouble();
		
		double avg = list.stream()
				.mapToInt( (Student s) -> {return s.getscore();} )
				// 매개값을 받아서 int 타입으로 리턴. (여기선 getScore의 값을 int 타입으로 리턴함.)
				.average()
				.getAsDouble();
		
		//위의 구문을 풀어서 코딩.
		Stream<Student> stream = list.stream();
		IntStream intStream = stream.mapToInt( (Student s) -> {return s.getscore();} );
		OptionalDouble odbl = intStream.average();
		avg = odbl.getAsDouble();
		System.out.println(avg);
	} 
}