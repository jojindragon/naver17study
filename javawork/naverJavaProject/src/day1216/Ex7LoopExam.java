package day1216;

import java.util.Scanner;

public class Ex7LoopExam {

	public static void main(String[] args) {
		/*
		 * 1. 지수 승 구하기 2. 팩토리얼 구하기 3. 원의 넓이 구하기 4. 종료 while 반복문에서 위 메뉴가 나오면 번호를 입력하고 해당
		 * 데이터를 입력후 결과 값 출력 1번 두 수 x, y를 입력후 x의 y승을 구해 출력(for문) 2번 숫자 n 입력 후 n! 값
		 * 구하기(for문) 3번 반지름 r 입력 후 원의 넓이 구하기 - Math.PI 그 이외 값 종료
		 */
		Scanner sc = new Scanner(System.in);
		int x, y, result;
		int n, r;
		long fact = 1;
		double area;
		int menu;

		Loop: while (true) {
			System.out.println("1. 지수 승 구하기   2. 팩토리얼 구하기  3. 원의 넓이 구하기 4. 종료");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				result = 1;
				System.out.println("== x ^ y의 값을 위해 값을 입력 ==");
				System.out.print("* x의 값: ");
				x = Integer.parseInt(sc.nextLine());
				System.out.print("* y의 값: ");
				y = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < y; i++) {
					result *= x;
				}
				System.out.println("결과: " + result);
				break;

			case 2:
				System.out.println("== n!의 값 구하기 ==");
				System.out.print("* n의 값: ");
				n = Integer.parseInt(sc.nextLine());
				for (int i = 1; i <= n; i++) {
					fact *= i;
				}
				System.out.println("결과: " + fact);
				break;

			case 3:
				System.out.println("== 원의 넓이 구하기 ==");
				System.out.print("* 반지름 길이: ");
				r = Integer.parseInt(sc.nextLine());
				area = r * r * Math.PI;
				System.out.printf("결과: %5.2f\n", area);
				break;

			default:
				System.out.println("프로그램 종료");
				break Loop;
			}

		}

	}

}
