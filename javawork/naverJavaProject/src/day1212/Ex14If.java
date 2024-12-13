package day1212;

import java.util.Scanner;

public class Ex14If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int score;
		String grade;
		System.out.println("점수 입력");
		score = sc.nextInt();
		
		// 0~100 범위 밖 입력 시 메서드 종료
		if (score > 100 || score < 0) {
			System.out.println("값의 범위 밖");
			return;
		}

		// 조건문 만들기
		if (score >= 90)
			grade = "A";
		else if (score >= 80)
			grade = "B";
		else if (score >= 70)
			grade = "C";
		else if (score >= 60)
			grade = "D";
		else
			grade = "F";

		System.out.printf("%d 점의 학점: %s\n", score, grade);

	}

}
