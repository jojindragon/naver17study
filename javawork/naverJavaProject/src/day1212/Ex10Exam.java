package day1212;

import java.util.Scanner;

public class Ex10Exam {

	public static void main(String[] args) {
		// 상품(sang), 수량(su), 단가(dan)을 입력받은 후 총금액(total)을 출력하시오
		// 단, 수량이 5개 이상이면 총금액의 10프로를 할인된 금액으로 출력해주세요
		Scanner sc = new Scanner(System.in);

		String sang;
		int su, dan, total;

		System.out.println("상품명 입력");
		sang = sc.nextLine();
		System.out.println("수량과 단가를 입력");
		su = sc.nextInt();
		dan = sc.nextInt();
		total = su < 5 ? su * dan : (int)(su * dan * 0.9);
		
		System.out.println("** 상품 정보 **");
		System.out.println("* 상품명: " + sang);
		System.out.println("* 수량: " + su + "개");
		System.out.println("* 단가: " + dan + "원");
		System.out.println("* 총 금액: " + total + "원"+(su<5?"":"(할인가)"));

	}

}
