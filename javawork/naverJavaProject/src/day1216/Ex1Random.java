package day1216;

import java.util.Random;

public class Ex1Random {

	public static void main(String[] args) {
		// 난수 발생 - 1. Math.random()
		System.out.println("Math.random - 0 ~ 1.0보다 작은 수 반환");
		for (int i = 0; i < 5; i++) {
			System.out.println(Math.random());
		}

		System.out.println("Math.random - 0 ~ 9 반환으로 변화");
		for (int i = 0; i < 5; i++) {
			int n = (int) (Math.random() * 10);
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();

		System.out.println("Math.random - 0 ~ 99 반환");
		for (int i = 0; i < 5; i++) {
			int n = (int) (Math.random() * 100);
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Math.random - 1 ~ 10 반환");
		for (int i = 0; i < 5; i++) {
			int n = (int) (Math.random() * 10) + 1;
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();

		// 2. Random 클래스
		System.out.println("** Random 클래스 **");
		Random r = new Random();

		System.out.println("* 0 ~ 9 난수");
		for (int i = 0; i < 5; i++) {
			int n = r.nextInt(10);
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println("* 1 ~ 100 난수");
		for (int i = 0; i < 5; i++) {
			int n = r.nextInt(100) + 1;
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println("* A ~ Z(65~90) 임의의 알파벳 나오게 하기");
		for (int i = 0; i < 5; i++) {
			char n = (char) (r.nextInt(26) + 65);
			System.out.print(n + " ");
		}

	}

}
