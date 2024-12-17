package privateTest;

import java.util.Scanner;

public class AnalyzeAlpha {

	public static void main(String[] args) {
		// 알파벳 분석 다듬은 버전
		Scanner sc = new Scanner(System.in);
		String message;
		int cnt = 0, lc = 0;
		int[] lowerAlpha = new int[26];
		int[] upperAlpha = new int[26];
		int[] num = new int[10];

		System.out.print("영문을 입력: ");
		message = sc.nextLine();

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c >= 'A' && c <= 'Z')
				upperAlpha[c - 'A']++;
			else if (c >= 'a' && c <= 'z')
				lowerAlpha[c - 'a']++;
			else if (c >= '0' && c <= '9')
				num[c - '0']++;
			else
				cnt++;
		}

		System.out.println("=".repeat(15));
		System.out.println("* 대문자");
		for (int i = 0; i < upperAlpha.length; i++) {
			if (upperAlpha[i] == 0)
				continue;
			if (lc == 4)
				System.out.println();

			System.out.printf("%c: %d개\t", 'A' + i, upperAlpha[i]);
			lc++;
		}

		System.out.println("\n* 소문자");
		lc = 0;
		for (int i = 0; i < lowerAlpha.length; i++) {
			if (lowerAlpha[i] == 0)
				continue;
			if (lc == 4)
				System.out.println();

			System.out.printf("%c: %d개\t", 'a' + i, lowerAlpha[i]);
			lc++;
		}

		System.out.println("\n* 숫자");
		lc = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0)
				continue;
			if (lc == 4)
				System.out.println();

			System.out.printf("%c: %d개\t", '0' + i, num[i]);
			lc++;
		}

		System.out.println("\n* 특수문자: " + cnt + "개");

	}

}
