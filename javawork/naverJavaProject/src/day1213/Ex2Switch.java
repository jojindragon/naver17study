package day1213;

import java.util.Scanner;

public class Ex2Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		char ch;
//		
//		System.out.println("알파벳 한글자 입력");
//		ch=sc.nextLine().charAt(0); // 문자열 첫 글자 반환
//		
//		switch (ch) {
//		case 'a':
//		case 'A':
//			System.out.println("Apple");
//			break;
//		case 'b':
//		case 'B':
//			System.out.println("Banana");
//			break;
//		case 'c':
//		case 'C':
//			System.out.println("Computer");
//			break;
//		default:
//			System.out.println("alphabet");
//		
//		}
		// 문자열 조건 테스트
		System.out.println("문자열 입력(대문자 X)");
		String msg = sc.nextLine();
		
		switch (msg) {
		case "red":
			System.out.println("빨강");			
			break;
		case "blue":
			System.out.println("파랑");			
			break;
		case "green":
			System.out.println("초록");			
			break;
		default:
			System.out.println("삼원색을 제외한 색상");
		}
	}

}
