package day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex8Exception {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int birthYear, age;
		try {
			System.out.print("태어난 년도: ");
			birthYear = Integer.parseInt(sc.nextLine());

			Date date = null;
			age = (date.getYear() + 1900) - birthYear;

			System.out.println("나이: " + age);

		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력! - " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("date 변수가 Null: " + e.getMessage());
		}

		System.out.println("정상 종료");
	}

}
