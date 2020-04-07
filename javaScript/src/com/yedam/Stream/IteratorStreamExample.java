package com.yedam.Stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStreamExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "김자바", "신용권");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("===============================");
		Stream<String> stream = list.stream();
		stream.forEach(s -> System.out.println(s.toString()));
	}
}
