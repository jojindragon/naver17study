package day1216;

import java.util.Random;
import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// 임의의 난수를 구하고 숫자 알아맞추기
		// 맞췄을 경우 - 계속하시겠습니까? y ==> 새로운 난수 발생, 카운트 변수 0으로 초기화
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num, rnd, cnt;
		char c;

		System.out.println("숫자 맞추기(1~100)");
		Exit: // label문:
		while (true) {
			rnd = r.nextInt(100) + 1;
			cnt = 1;

			while (true) {
				System.out.print("숫자 입력: ");
				num = Integer.parseInt(sc.nextLine());

				if (num > rnd) {
					System.out.println("down");
				} else if (num < rnd) {
					System.out.println("up!");
				} else {
					System.out.println("정답입니다! " + cnt + "번 만에 맞췄습니다.");
					System.out.println("다시 하시겠습니까(y)?");
					c = sc.nextLine().charAt(0);

					if (c == 'y' || c == 'Y') {
						System.out.println("새로운 난수가 발생!");
						break;
					} else {
						break Exit;
					}

				}
				cnt++;
			}
		}

		System.out.println("프로그램 종료");

	}

}
