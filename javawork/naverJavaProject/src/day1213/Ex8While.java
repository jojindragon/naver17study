package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		// 1~입력한 숫자 n까지의 합계 출력(printf)
		Scanner sc = new Scanner(System.in);
		int num, sum = 0, tmp;

		while (true) {
			try {
				System.out.printf("숫자 입력: ");
				num = sc.nextInt();
				if (num > 0) {
					break;
				}
				System.out.println("다시 입력해라.");
			} catch (Exception e) {
				System.out.println("숫자만 입력해라.");
				sc.next(); // 버퍼 지우기
			}
		}

		tmp = num;
		while (num > 0) {
			sum += num;
			num--;
		}

		System.out.printf("입력한 숫자 %d에 대한 결과 값: %d\n", tmp, sum);

	}

}
