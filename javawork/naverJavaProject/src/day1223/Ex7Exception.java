package day1223;

import java.util.Date;

public class Ex7Exception {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 12 };
		// ArrayIndexOutOfBoundsException
		for (int i = 0; i <= arr.length; i++) {
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("오류: " + e.getMessage());
//				e.printStackTrace(); // 오류추적을 위해 행번호도 표시
			}
		}
		System.out.println("=".repeat(20));

		Date date = null;
		try {
			int age = (date.getYear() + 1900) - 2001;
			System.out.println("age=" + age);
		} catch (NullPointerException e) {
			System.out.println("오류: " + e.getMessage());
		}

		System.out.println("정상종료");
	}

}
