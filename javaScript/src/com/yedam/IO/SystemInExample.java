package com.yedam.IO;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {
	public static void main(String[] args) throws IOException {
		System.out.println("입력: ");
		InputStream is = System.in;// 시스템인:콘솔입력
		int readByte;
		while ((readByte = is.read()) != -1) {
			System.out.print((char) readByte);
		}
		is.close();
	}
}
