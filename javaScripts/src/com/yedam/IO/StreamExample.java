package com.yedam.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) throws IOException {
		List<String> list = Arrays.asList("홍길동", "김유신", "하준원", "옹성우");

		File file = new File("src/com/yedam/io/Name.txt");
		FileOutputStream fos = new FileOutputStream(file);
		// ==> name.txt 출력하는

		for (String b : list) {
			fos.write(b.getBytes());
		}
		fos.flush();
		fos.close();
System.out.println(file);
	}
}
