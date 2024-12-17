package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		// 인원수와 그 만큼의 이름&점수 입력 > 등수, 총점, 평균 구하기
		Scanner sc = new Scanner(System.in);
		int p, total = 0;
		int[] score, rank;
		String[] name;
		double avg;

		System.out.print("총 정원 수 입력: ");
		p = Integer.parseInt(sc.nextLine());
		score = new int[p];
		rank = new int[p];
		name = new String[p];

		for (int i = 0; i < p; i++) {
			System.out.print("이름: ");
			name[i] = sc.nextLine();
			while (true) {
				try {
					System.out.print("성적: ");
					score[i] = Integer.parseInt(sc.nextLine());
					if (score[i] >= 0 && score[i] <= 100)
						break;

					System.out.println("범위 밖 성적 값");
				} catch (Exception e) {
					System.out.println("숫자 입력해라.");
				}
			}

			System.out.println("-".repeat(10));
			total += score[i];
		}

		avg = (double) total / p; // 평균
		// 등수
		for (int i = 0; i < p; i++) {
			rank[i] = 1;
			for (int j : score)
				if (score[i] < j)
					rank[i]++;
		}

		System.out.println("이름\t성적\t등수");
		System.out.println("=".repeat(20));
		for (int i = 0; i < p; i++)
			System.out.println(i + 1 + "\t" + score[i] + "\t" + rank[i]);
		System.out.printf("총점: %d\t평균: %5.2f", total, avg);

	}

}
