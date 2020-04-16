package com.yedam.lambda;

import java.awt.Toolkit;

public class 쓰리람다표현식{
   public static void main(String[] args) {
      Toolkit tkit = Toolkit.getDefaultToolkit();
      Thread thread = new Thread(() -> {
         for (int i = 0; i < 10; i++) {
            tkit.beep();
            try {
               Thread.sleep(500);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });
      thread.start();

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