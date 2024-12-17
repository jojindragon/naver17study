package day1217;

import java.util.Scanner;

public class Ex8ArrayAlpha {

	public static void main(String[] args) {
		// 영문을 입력 > 알파벳을 분석, 그 갯수 구하기
		Scanner sc = new Scanner(System.in);
		String message;
		int cnt = 0;
		int[] alpha = new int[26];

		System.out.print("영문을 입력: ");
		message = sc.nextLine();

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c >= 'A' && c <= 'Z')
				alpha[c - 'A']++;
			else if (c >= 'a' && c <= 'z')
				alpha[c - 'a']++;
			else
				cnt++;
		}

		System.out.println("=".repeat(15));
		for (int i = 0; i < alpha.length; i++) {
			if ((i + 1) % 4 == 0)
				System.out.println();

			if (alpha[i] == 0)
				continue;
//			System.out.printf("%c: %d개\t", 'A' + i, alpha[i]);
			System.out.print((char) ('A' + i) + ": " + alpha[i] + "개\t");

		}
		System.out.println("특수문자: " + cnt + "개");

	}

}
