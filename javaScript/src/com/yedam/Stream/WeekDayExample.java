package com.yedam.Stream;

public class WeekDayExample {
	public static void main(String[] args) {
		WeekDay today = WeekDay.MONDAY;
		WeekDay yday = WeekDay.TUESDAY;
		if (today == WeekDay.TUESDAY) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		} // 이거시 열거형이라고라고라파덕
	}
}