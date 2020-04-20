package co.yedam.app.test;

import java.util.Scanner;

public class ddds {

	public static void main(String[] args) {
		int money, tag, vat, change;

		Scanner input = new Scanner(System.in);
		System.out.print("받은돈: ");
		money = input.nextInt();

		System.out.print("상품의총액: ");
		tag = input.nextInt();

		vat = tag / 10; // 상품종액에서10%의세금을포함한다고가정하자
		change = money - tag;
		System.out.println("부가세: " + vat);
		System.out.println("잔돈: " + change);

	}
}
