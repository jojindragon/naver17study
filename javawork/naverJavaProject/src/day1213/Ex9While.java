package day1213;

import java.util.Scanner;

public class Ex9While {

	public static void main(String[] args) {
		// 1글자씩 입력하다가 대소문자 구분 없이 x를 누르면빠져나와서 입력한 데이터들을 분석한 결과를 출력
		// 대문자: 3, 소문자: 4, 숫자: 5
		Scanner sc = new Scanner(System.in);
		char ch;
		int upper = 0, lower = 0, number = 0;

		System.out.println("** 문자 분석(종료를 원하면 x 입력) **");

		while (true) {
			System.out.print("분석할 문자 입력: ");
			ch = sc.nextLine().charAt(0);

			if ('A' <= ch && 'Z' >= ch)
				upper++;
			if ('a' <= ch && 'z' >= ch)
				lower++;
			if ('1' <= ch && '9' >= ch)
				number++;

			if (ch == 'x' || ch == 'X') {
				System.out.println("종료");
				break;
			}
		}

		System.out.println("문자 분석 결과");
		System.out.printf("대문자: %d개, 소문자: %d개, 숫자: %d개", upper, lower, number);

	}

}
