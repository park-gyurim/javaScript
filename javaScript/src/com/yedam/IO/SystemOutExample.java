package com.yedam.IO;

import java.io.IOException;
import java.io.PrintStream;

public class SystemOutExample {
	public static void main(String[] args) throws IOException {
		PrintStream ps = System.out;
		String text = "한글은 위대한 언어입니다.";
		byte[] cbuf = text.getBytes();
		int readChar;
		ps.write(cbuf);
		ps.flush();
	}
}
