package day1216;

import java.util.Scanner;

public class Ex2Random {

	public static void main(String[] args) {
		// 임의의(1~100) 수를 rnd를 생성하고 숫자 알아 맞추기
		// - up/down 정보도 알려주고 몇번 만에 맞췄는지도 출력
		Scanner sc = new Scanner(System.in);
		int num, rnd, cnt = 1;
		rnd = (int) (Math.random() * 100) + 1;

		System.out.println("숫자 맞추기(1~100)");
		while (true) {
			System.out.print("숫자 입력: ");
			try {
				num = sc.nextInt();
				if (num == rnd)
					break;

				if (num > rnd) {
					System.out.println("down");
				} else {
					System.out.println("up!");
				}
			} catch (Exception e) {
				System.out.println("숫자 좀 입력해라!");
				sc.next();
			}

			cnt++;

		}
		System.out.println("정답입니다! " + cnt + "번 만에 맞췄습니다.");

	}

}
