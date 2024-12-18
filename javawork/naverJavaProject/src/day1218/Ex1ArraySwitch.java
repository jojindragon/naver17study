package day1218;

import java.util.Scanner;

public class Ex1ArraySwitch {

	public static void main(String[] args) {
		// 인원수 입력 후 인원 수 만큼 이름과 두 점수(자바, 스프링)를 입력 후
		// 총점/평균/등수/등급을 구하기
		Scanner sc = new Scanner(System.in);
		int p;
		int[] java, spring, sum, rank;
		String[] name, grade;
		double[] avg;

		System.out.print("입력할 총 인원수: ");
		p = Integer.parseInt(sc.nextLine());
		java = new int[p];
		spring = new int[p];
		sum = new int[p];
		rank = new int[p];

		name = new String[p];
		grade = new String[p];

		avg = new double[p];

		// 입력
		for (int i = 0; i < p; i++) {
			System.out.println((i + 1) + "번째 사람 정보");
			System.out.print("이름: ");
			name[i] = sc.nextLine();
			System.out.print("Java 점수: ");
			java[i] = Integer.parseInt(sc.nextLine());
			System.out.print("Spring 점수: ");
			spring[i] = Integer.parseInt(sc.nextLine());

			sum[i] = java[i] + spring[i];
			avg[i] = sum[i] / 2.0;
			System.out.println("-".repeat(10));
		}

		// 등수&등급
		for (int i = 0; i < p; i++) {
			rank[i] = 1;
			for (int j = 0; j < p; j++) {
				if (avg[i] < avg[j])
					rank[i]++;
			}

			// 등급
//			switch ((int) avg[i] / 10) {
//			case 10:
//			case 9:
//				grade[i] = "우수장학";
//				break;
//
//			case 8:
//				grade[i] = "일반장학";
//				break;
//
//			default:
//				grade[i] = "해당없음";
//			}
			grade[i] = switch ((int) avg[i] / 10) {
			case 10, 9 -> "우수장학";
			case 8 -> "일반장학";
			default -> "해당없음";
			};
		}

		// 출력
		System.out.println("=".repeat(60));
		System.out.println("번호\t이름\t자바\t스프링\t총점\t평균\t등수\t등급");
		System.out.println("=".repeat(60));
		for (int i = 0; i < p; i++) {
			System.out.println(i + 1 + "\t" + name[i] + "\t" + java[i] + "\t" + spring[i] + "\t" + sum[i] + "\t"
					+ avg[i] + "\t" + rank[i] + "\t" + grade[i]);
		}
	}

}
