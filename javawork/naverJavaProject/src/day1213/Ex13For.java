package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// 문제2. 5명의 나이를 입력 후 40세 이상과 미만이 각각 몇명인지 출력하고 평균 나이 또한 출력
		Scanner sc = new Scanner(System.in);
		String age;
		int tmp, cnt1 = 0, cnt2 = 0, sum = 0;
		double avg;

		System.out.println("5명의 나이를 각각 입력해주세요.");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "번째 나이 입력");
			age = sc.nextLine();
			tmp = Integer.parseInt(age);

			// 0~100 밖 범위 제외
			if (tmp <= 0 || tmp > 100) {
				i--;
				System.out.println("범위 밖 값이다. 다시 입력.");
				continue;
			}

			if (tmp < 40)
				cnt1++;
			else
				cnt2++;

			sum += tmp;
		}

		avg = sum / 5.0;

		System.out.println("40세 미만 인원: " + cnt1 + "명");
		System.out.println("40세 이상 인원: " + cnt2 + "명");
		System.out.printf("평균 나이: %5.1f세", avg);

	}

}
