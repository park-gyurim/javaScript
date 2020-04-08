package com.yedam.Stream;

import java.util.Arrays;

public class MatchExample {
	public static void main(String[] args) {
		int[] intArr = { 2, 4, 6 };
		boolean isTrue = Arrays.stream(intArr)
				.allMatch(n -> n % 2 == 0); // allMatch()는 모든 조건 만족
											// anyMatch()는 조건 하나만 만족
											// noneMatch()는 모든 조건 불만족
		if(isTrue) {
			System.out.println("전체 짝수");
		} else {
			System.out.println("0 또는 홀수");
		}
	}
}