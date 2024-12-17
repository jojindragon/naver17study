package day1217;

import java.util.Date;
import java.util.Scanner;

public class Ex1Calendar {

	public static void main(String[] args) {
		/*
		 * 달력 만들기 - 연월일 년도&월을 입력하면 해당월의 달력을 출력 1. 그 월의 1일이 무슨 요일? 2. 그월이 몇일까지 있는가
		 */
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth;
		int endDays, weekDay; // 며칠까지와 요일숫자
		boolean leapYear; // 윤년 여부

		System.out.print("년도를 입력: ");
		inputYear = sc.nextInt();
		System.out.print("월을 입력: ");
		inputMonth = sc.nextInt();

		// 1~12 범위 값 측정
		if (inputMonth < 1 || inputMonth > 12) {
			System.out.println("달력 모름?");
			return;
		}

		// 윤년 측정
		leapYear = inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0;
		if (leapYear)
			System.out.println(inputYear + "년은 윤년");
		else
			System.out.println(inputYear + "년은 평년");

		// 달력 계산
		Date inputDate = new Date(inputYear - 1900, inputMonth - 1, 1);
		weekDay = inputDate.getDay();

		switch (inputMonth) {
		case 2:
			endDays = leapYear ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endDays = 30;
			break;
		default:
			endDays = 31;
			break;
		}

		// 출력
		System.out.println("=".repeat(50));
		System.out.println("\t\t[" + inputYear + "년 " + inputMonth + "월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토\t");
		System.out.println("=".repeat(50));

		// 시작 요일 설정
		for (int i = 1; i <= weekDay; i++)
			System.out.print("\t");

		for (int i = 1; i <= endDays; i++) {
			++weekDay;
			System.out.printf("%2d\t", i);
			if (weekDay % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("=".repeat(50));

	}

}
