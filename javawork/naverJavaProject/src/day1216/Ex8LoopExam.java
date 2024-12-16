package day1216;

import java.util.Scanner;

public class Ex8LoopExam {

	public static void main(String[] args) {
		/*
		 * 이름을 입력하면 그 중 "김"씨 성을 가진 사람의 인원수 "이"씨 성을 가진 사람의 인원수 그 이외의 인원수를 각각 구해 출력
		 * (while문) startsWith, equals
		 */
		Scanner sc = new Scanner(System.in);
		String name;
		int kimCnt = 0, leeCnt = 0, otherCnt = 0;

		System.out.println("성씨 구별(끝내려면 끝이나 엔터를 1번 더 입력)");
		while (true) {
			System.out.print("이름을 입력: ");
			name = sc.nextLine();

			if (name.equals("") || name.equals("끝")) {
				System.out.println("== 정산 완료 ==");
				break;
			}

			if (name.startsWith("김"))
				kimCnt++;
			else if (name.startsWith("이"))
				leeCnt++;
			else
				otherCnt++;
		}

		System.out.println("김씨 사람: " + kimCnt + "명");
		System.out.println("이씨 사람: " + leeCnt + "명");
		System.out.println("이외 사람들: " + otherCnt + "명");

	}

}
