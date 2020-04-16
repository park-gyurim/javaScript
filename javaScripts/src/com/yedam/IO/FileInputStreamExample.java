package com.yedam.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "src/com/yedam/io/input.txt";
		FileInputStream fis = new FileInputStream(path);
		String outPath = "src/com/yedam/io/output.txt";// 경로
		FileOutputStream fos = new FileOutputStream(outPath);//클래스(파일)을 만들어내는 코드
		int readByte;
		while ((readByte = fis.read()) != -1) {
			fos.write(readByte);
//			readByte = fis.read();
//			if(readByte == -1) {
//				break;
//			}
		
			System.out.print((char) readByte);
		}
		fos.flush();
		fos.close();
		fis.close();
	}
}

