package day1213;

import java.util.Scanner;

public class Ex3Switch {

	public static void main(String[] args) {
		// 연월을 입력 후 윤년/평년 여부를 출력 - 윤년: 연도%4==0 && 연도%100 != 0 || 연도 % 400 == 0
		// 또한 그 월이 몇일까지 있는지 출력
		Scanner sc = new Scanner(System.in);
		int year, month, days;

		System.out.println("연도와 월을 입력하시오.");
		year = sc.nextInt();
		month = sc.nextInt();

		boolean check = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if (check)
			System.out.println(year + "도는 윤년이다.");
		else
			System.out.println(year + "도는 평년이다.");

		switch (month) {
		case 2:
			days = check ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		default:
			days = -1;
			break;
		}

		if (days == -1)
			System.out.println("범위 밖 값입니다.");
		else
			System.out.printf("%d / %d / %d", year, month, days);

	}

}
