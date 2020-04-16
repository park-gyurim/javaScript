package com.yedam.Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LoopingExample {
	public static void main(String[] args) {
		// peek() 메소드
		int[] intArr = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArr);
		int sum = intStream.filter(n -> n % 2 == 0) // test()
				.peek(s -> System.out.println(s)) // 중간처리 단계 메소드다.
				.sum();
		System.out.println("결과값: " + sum);

		// forEach() 메소드
		intStream = Arrays.stream(intArr);
		intStream.filter(n -> n % 2 == 0)
				.forEach(s -> System.out.println(s)); //최종처리 단계 메소드다.
	}

}