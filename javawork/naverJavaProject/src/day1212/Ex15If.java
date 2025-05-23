package day1212;

import java.util.Scanner;

public class Ex15If {

	public static void main(String[] args) {
		// Ex10Exam을 조건문으로
		// 추가 사항: 무조건 총금액을 띄우고 수량이 5개 이상인 경우에만 출력되는 문장
		// ==> 10% DC된 금액은 ???원입니다.
		Scanner sc = new Scanner(System.in);

		String sang;
		int su, dan, total;

		System.out.println("상품명 입력");
		sang = sc.nextLine();
		System.out.println("수량과 단가를 입력");
		su = sc.nextInt();
		dan = sc.nextInt();
		total = su * dan;

		System.out.println("** 상품 정보 **");
		System.out.println("* 상품명: " + sang);
		System.out.println("* 수량: " + su + "개");
		System.out.println("* 단가: " + dan + "원");
		System.out.println("* 총 금액: " + total + "원");
		if (su >= 5)
			System.out.println("10% DC된 금액은 " + ((int) (total * 0.9)) + "원입니다.");

	}

}
