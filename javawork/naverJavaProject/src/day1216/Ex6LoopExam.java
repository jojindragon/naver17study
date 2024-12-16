package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// 문자열 str을 입력 후 엔터를 누르면, 분석해서
		// 대문자/소문자/숫자 각각의 갯수를 구해서 출력하시오.
		// 사용할 문자메소드: length(), charAt()

		Scanner sc = new Scanner(System.in);
		String str;
		int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
		char c;
		System.out.println("* 문자열을 입력하시오 *");
		str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);

			if (c >= 'A' && c <= 'Z')
				cnt1++;
			else if (c >= 'a' && c <= 'z')
				cnt2++;
			else if (c >= '0' && c <= '9')
				cnt3++;
			else
				cnt4++;
		}
		System.out.println("== 분석 결과 ==");
		System.out.println("대문자: " + cnt1 + "개");
		System.out.println("소문자: " + cnt2 + "개");
		System.out.println("숫자: " + cnt3 + "개");
		System.out.println("특수문자: " + cnt4 + "개");

	}

}
