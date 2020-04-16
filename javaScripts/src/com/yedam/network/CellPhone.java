package com.yedam.network;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CellPhone {
	static String fileName = "전화번호부.txt";

	static class Address {
		String name;
		String age;
		String phone;

		public Address(String name, String age, String phone) {
			super();
			this.name = name;
			this.age = age;
			this.phone = phone;
		}

	}

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("친구 연락처 텍스트파일백업 프로그램");
		System.out.println("1.추가 2.조회");
		int menu = scn.nextInt();
		
		if (menu == 1) {
			System.out.println("이름을 입력하세요");
			String name = scn.nextLine();
			System.out.println("나이를 입력하세요");
			String age = scn.nextLine();
			System.out.println("번호를 입력하세요");
			String phone = scn.nextLine();
			
			Address addr = new Address(name, age, phone);
			
			
			try {
				FileWriter fw = new FileWriter(fileName, true);
				fw.write("\n" + addr.name + "," + addr.age + "," + addr.phone + "\n");
				fw.flush();
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("프로그램종료");
			}
		
		if (menu == 2) {
			System.out.println("이름을 입력하세요");
			String name = scn.nextLine();
			name.equals(name);
			
		}
		
			try {
				FileReader fr = new FileReader(fileName);
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}
	}
}
