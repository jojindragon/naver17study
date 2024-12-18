package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Exam {

	public static void main(String[] args) {
		// 년(year), 월(month), 일(date)를 입력 후 해당 날짜에 대한 Date 클래스를 생성(myDate)
		// 이후 이를 이용해서 년도, 월, 일, 요일(week)을 구해서 출력하시오.
		// 단, 요일은 요일 숫자를 먼저 얻고 요일을 구해서 출력해라.
		Scanner sc = new Scanner(System.in);
		int year, month, day;
		String week;

		System.out.println("연도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		System.out.println("일 입력");
		day = sc.nextInt();

		Date myDate = new Date(year - 1900, month - 1, day);
		int weekNum = myDate.getDay();
		week = weekNum == 0 ? "일" : weekNum == 1 ? "월" : weekNum == 2 ? "화" 
				: weekNum == 3 ? "수" : weekNum == 4 ? "목" : weekNum == 5 ? "금" : "토";

		System.out.println("** 입력한 날짜 정보 **");
		System.out.println("* 연월(YYYY/MM/DD): " + (myDate.getYear() + 1900) + "/" + (myDate.getMonth() + 1) 
				+ "/" + myDate.getDate());
		System.out.println("* " + weekNum + "번째 요일 - " + week + "요일");

	}

}
