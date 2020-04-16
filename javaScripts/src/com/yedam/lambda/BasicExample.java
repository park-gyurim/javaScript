package com.yedam.lambda;

import java.awt.Toolkit;

public class BasicExample {
	public static void main(String[] args) {
//		Runnable rcs = new Runnable() {
			@Override
			public void run() {
				Thread thread = new Thread(rcs);
			}//신규작업 인스턴스
		};
		
		//쓰레드생성
		thread.start(); //신규쓰레드작업
		for (int i = 0; i < 10; i++) {
			tkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("print it.=> " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
