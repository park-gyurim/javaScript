package com.yedam.lambda;

import java.util.function.BiConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		BiConsumer<Students, String> biCon = (std, str) -> {
			System.out.println(str + " ");
			std.getInfo();// 안녕하새요 이름:?? 나이:??
		};
		Students s1 = new Students("Hwang", 20);
		String s2 = "안녕하세요.";
		biCon.accept(s1, s2);
//		printAccept(biCon, s1, s2);
		BiConsumer<String, String> biStr = (str1, str2) -> {
			System.out.println(str1 + ""  + str2);
		};
		biStr.accept("람다","헷갈려씨부레");
	}

	static <T, U> void printAccept(BiConsumer<Students, String> biCon, Students std, String str) {
		biCon = (s1, s2) -> {
			System.out.println(s2 + " ");
			s1.getInfo();
		};
		biCon.accept(std, str);
	} 
}
