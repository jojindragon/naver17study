package day1212;

import java.util.Date;

public class Ex6Date {
	public static void main(String[] args) {
		// 현재 날짜와 시간을 얻어보기
		// Date 클래스 - jdk1.1 이후 deprecate 됨 - Calendar 권장
		Date today = new Date();

		int curYear = today.getYear() + 1900; // 기본적으로 1900 뺸 값 반환

		int curMonth = today.getMonth() + 1; // 0~11 반환 => +1 필요
		int curDate = today.getDate();

		int curDay = today.getDay(); // 요일 순서가 출력(0~6 : 일~토)
		String week = curDay == 0 ? "일" : curDay == 1 ? "월": curDay == 2 ? "화" : 
			curDay == 3 ? "수" : curDay == 4 ? "목" : curDay == 5 ? "금" : "토";

						System.out.println("현재년도: " + curYear);
		System.out.println("현재월 : " + curMonth);
		System.out.println("현재 일: " + curDate);
		System.out.println("현재 요일 : " + week + "요일");

		System.out.println("시간 : " + today.getHours() + ":" + today.getMinutes());
	}

}
