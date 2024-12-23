package day1223;

import java.util.Scanner;

public class Ex10Throws {
	// 호출하는 곳으로 NumberFormatException을 던진다.
	public static void sum(String a, String b) throws NumberFormatException {
		int su1 = Integer.parseInt(a);
		int su2 = Integer.parseInt(b);
		int sum = su1 + su2;
		System.out.println(a + "+" + b + "=" + sum);
	}

	public static void main(String[] args) {
		// throws 예약어 예시
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자1: ");
		String s1 = sc.nextLine();
		System.out.print("숫자2: ");
		String s2 = sc.nextLine();

		try {
			sum(s1, s2); // throws로 던져져서 호출하는 이곳에서 받음
		} catch (NumberFormatException e) {
			System.out.println("오류 발생: " + e.getMessage());
		} finally { // 예외 발생 여부와 상관없이 실행
			System.out.println("마참내--");
		}

		System.out.println("정상 종료");

	}

}
