package com.yedam.lambda;

import java.awt.Toolkit;

public class 투익명객체 {

   public static void main(String[] args) {
      Runnable rcs = new Runnable() {
         Toolkit tkit = Toolkit.getDefaultToolkit();

         @Override
         public void run() {
            for (int i = 0; i < 10; i++) {
               tkit.beep();
               try {
                  Thread.sleep(500);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
         }
      };
      Thread thread = new Thread(rcs);
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