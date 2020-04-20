package co.yedam.app.test;

import java.util.Scanner;

public class Money {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		

		System.out.println("이 프로그램은 실제 가격과 할인률을 지정하면");
		System.out.println("얼마가 깍히는지, 할인된 가격은 얼마인지");
		System.out.println("구하는 프로그램 입니다");
		System.out.println("");
		System.out.println("판매가를 입력하세요: ");
		
		int money = scn.nextInt(); // 할인의 대상이 되는 원금 [수정 필요]
		System.out.println("할인율을 입력하세요: ");
		int percent = scn.nextInt(); // 20%의 할인 [수정 필요]
		System.out.println("원금: " + money + ", 할인률: " + percent + "%");
		sale(money, percent);
		System.out.println("");
		System.out.println("프로그램을 마칩니다");
	}

	public static void sale(int money, double percent) // money은 원금이며 percent는 할인률이다
	{
		double M3 = percent * 0.01; // M3는 %를 소수점으로 변환한 값이다 즉 20%를 0.2로 변환한다
		double yourmoney = money * M3; // 할인되는 가격
		double actually = money - yourmoney; // 실제 가격
		System.out.println("할인되는 가격: " + yourmoney + ", 실제 가격: " + actually);
	}
}
