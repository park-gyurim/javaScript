package com.yedam.lambda;

import java.awt.Toolkit;

class RunnableCls implements Runnable {
   @Override
   public void run() {
      Toolkit tkit = Toolkit.getDefaultToolkit();
      for (int i = 0; i < 10; i++) {
         tkit.beep();
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

   }
}

public class 원구현클래스 {
   public static void main(String[] args) {
      RunnableCls rcs = new RunnableCls(); // Runnable클래스의 인스턴스를 생성.
      Thread thread = new Thread(rcs); // Thread클래스는 Runnable 클래스의 인스턴스를 매개값으로 받는다. (API 문서 설명)
      thread.start(); // Thread클래스 안에는 start라는 메소드가 있다.

      for (int i = 0; i < 10; i++) {
         System.out.println("print it." + i);
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}