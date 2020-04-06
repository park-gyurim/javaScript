package com.yedam.lambda;

import java.util.function.IntBinaryOperator;

class IntBinaryClass implements IntBinaryOperator {

	@Override
	public int applyAsInt(int left, int right) {
		if (left >= right) {
			return left;
		} else {
			return right;
		}
	}
}

public class OperatorExample {
	static int[] scores = { 92, 95, 87 };

	public static int maxOrMin(IntBinaryOperator oper) {
		int result = scores[0];
		for (Integer score : scores) {
			result = oper.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		IntBinaryClass iclass = new IntBinaryClass();
		int result = maxOrMin(iclass);// 여기까지 구현클래스

		result = maxOrMin(new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				// TODO Auto-generated method stub
				if (left >= right) {
					return right;
				} else {
					return left;
				}
			}

		});// 여기까지 익명객체
	result  = maxOrMin((left,right) -> {
		if(left >= right) {
			return right;
		}else {
			return left;
		}
	}); //여기까지 람다표현식

		System.out.println("결과: " + result);
	}
}
