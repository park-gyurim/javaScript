package com.yedam.calculator;

import java.math.BigDecimal;



public class Calculate {

double calNum;

double result;

BigDecimal calNumBig;

BigDecimal resultBig;

char symbol;


Calculate () {

initAllElement();

}

public int calculate() {

resultBig = new BigDecimal(this.result);

calNumBig = new BigDecimal(this.calNum);

switch(this.symbol) {

case '+' : result = resultBig.add(calNumBig).doubleValue(); break;

case '-' : result = resultBig.subtract(calNumBig).doubleValue(); break;

case '*' : if(searchE(resultBig.multiply(calNumBig).toString().toCharArray())) // 축약형이면 소수점 9째짜리를 반올림

  result = resultBig.multiply(calNumBig).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue(); 

  else // 축약형(지수형)이 아니면 그대로 표현

  result = resultBig.multiply(calNumBig).doubleValue();

  break;

case '/' : 

try { result = resultBig.divide(calNumBig, 8 , BigDecimal.ROUND_HALF_UP).doubleValue(); } 

catch(ArithmeticException e) { return 0; } break;

default  : result = calNumBig.doubleValue(); return 2; // 연산 기호가 없으면 calNum을 result에 대입

}

return 1;

}


public void setCalNum(double number) { this.calNum = number; }


public void setSymbol(char symbol) { this.symbol = symbol; }


public void initAllElement() { calNum = 0; result = 0; symbol = 0; resultBig = new BigDecimal(0); calNumBig = new BigDecimal(0); }


public void initAllNumber() { result = 0; calNum = 0; resultBig = new BigDecimal(0); calNumBig = new BigDecimal(0); }


public void initCalNum() { calNum = 0; calNumBig = new BigDecimal(0); }


public void initSymbol() { symbol = 0; }


public void stringToCalNum(String stringNumber) { calNum = Double.parseDouble(stringNumber); }


public String resultToString() { return new Double(result).toString(); }


public boolean searchE(char[] array) { // 문자열에서 E가 발견되면 true를 리턴

for(int i = 0; i < array.length; i++)

if(array[i] == 'E')

return true;

return false;

}

}