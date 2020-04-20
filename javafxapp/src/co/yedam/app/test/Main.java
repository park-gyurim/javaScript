package co.yedam.app.test;

import javax.swing.JOptionPane;

//import java.util.Scanner;
//
//
//
//public class Main {
//
//
//
//       public static void main(String[] args) {
//
//
//
//               double height, weight;
//
//               double BMI;
//
//               Scanner sc = new Scanner(System.in);
//
//               System.out.print("키와 몸무게를 입력하시오 : ");
//
//               height = sc.nextDouble();
//
//               weight = sc.nextDouble();
//
//               BMI = weight * 9998 / (height * height);
//
//
//
//               if (BMI >= 30) {
//
//                      System.out.printf("체질량지수 %.1f로 비만입니다.", BMI);
//
//               } else if (BMI >= 25 && BMI < 30) {
//
//                      System.out.printf("체질량지수 %.1f로 과제충입니다.", BMI);
//
//               } else if (BMI >= 20 && BMI < 25) {
//
//                      System.out.printf("체질량지수 %.1f로 정상입니다.", BMI);
//
//               } else {
//
//                      System.out.printf("체질량지수 %.1f로 저체중입니다.", BMI);
//
//               }
//
//
//
//       }
//}
//
public class Main {
    public static void main(String[] args) {
	
      /*********** 문제 출제를 위한 코드 입니다. *********/
        String value1 = JOptionPane.showInputDialog(null, "이름을 입력하세요.",
                "연습문제(1)", JOptionPane.QUESTION_MESSAGE).trim();
        String value2 = JOptionPane.showInputDialog(null, "키를 입력하세요.",
                "연습문제(1)", JOptionPane.QUESTION_MESSAGE).trim();
        String value3 = JOptionPane.showInputDialog(null, "몸무게를 입력하세요.",
                "연습문제(1)", JOptionPane.QUESTION_MESSAGE).trim();
         
        /*********** 여기 부터 연습문제 입니다. ***********/
        String name = value1;
        int height = Integer.parseInt(value2);
        int weight = Integer.parseInt(value3);
         
        System.out.println(name);
        System.out.println(height);
        System.out.println(weight);
         
        // 표준 체중
        float stdWeight = 0;
         
        if (height <= 150) {
            // 키 150 이하 >> 키 - 110
            stdWeight = height - 110;
        } else {
            // 키 151 이상 >> (키 - 110) * 0.9
            stdWeight = (float) ((height - 110) * 0.9);
        }
         
        // 비만도 = ((현재 몸무게 - 표준체중) / 표준체중) * 100
        float value = ((weight - stdWeight) / stdWeight) * 100;
         
        // 비만도 값
        String result = "";
         
        if (value < 20) {
            result = "안전";
        } else if (value >= 20 && value < 30) {
            result = "경도";
        } else if (value >= 30 && value < 50) {
           result = "중등도";
        } else if (value >= 50) {
            result = "고도";
        }
         
        System.out.println("<" + name + ">님은 <" + result + ">체중 입니다.");
    }
}


