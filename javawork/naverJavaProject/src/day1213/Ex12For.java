package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// 문제1 숫자 n 입력시 1~n 까지의 합 출력
		Scanner sc = new Scanner(System.in);
		int n, sum = 0;

		System.out.print("숫자를 입력: ");
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.printf("1 ~ %d까지의 합: %d", n, sum);
	}

}
