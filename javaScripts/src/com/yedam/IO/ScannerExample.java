package com.yedam.IO;

import java.util.Scanner;

public class ScannerExample {
public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	System.out.println("이름을 입력하세요:");
	String  name =  scn.nextLine();
	System.out.println("나이를 입력하새요");
	int age = scn.nextInt();
	System.out.println("키를 입력하세요");
	double height = scn.nextDouble();
	
	System.out.println(name + "," + age + "," + height);
	scn.close();
	}
}

