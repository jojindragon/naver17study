package day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex9Exception {

	public static void main(String[] args) {
		// Ex8 예제에서 catch 2개 하나로 합치기
		Scanner sc = new Scanner(System.in);
		int birthYear, age;
		try {
			System.out.print("태어난 년도: ");
			birthYear = Integer.parseInt(sc.nextLine());

			Date date = null;
			age = (date.getYear() + 1900) - birthYear;

			System.out.println("나이: " + age);

		} catch (NumberFormatException|NullPointerException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		System.out.println("정상 종료");
	}

}
