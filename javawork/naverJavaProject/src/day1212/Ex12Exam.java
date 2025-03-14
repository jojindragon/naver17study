package day1212;

import java.util.Scanner;

public class Ex12Exam {

	public static void main(String[] args) {
		// 이름(name)과 3과목 점수를 입력받고 총점(sum)과 평균(avg), 등급(grade), 합격여부를 출력하시오
		// 등급: 평균이 90 이상 "우등장학생", 80 "50프로장학금", 나머지 "노력" => 출력
		// 합격여부: 3과목이 50 이상이고 평균이 모두 70이상 => "합격입니다", 나머지 => "불합격입니다"
		String name, grade;
		Integer java, html, spring, sum;
		double avg;

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력");
		name = sc.nextLine();
		System.out.println("Java 점수는?");
		java = sc.nextInt();
		System.out.println("Html 점수는?");
		html = sc.nextInt();
		System.out.println("Spring 점수는?");
		spring = sc.nextInt();

		sum = java + spring + html;
		avg = sum / 3.0;
		grade = avg >= 90 ? "우등장학생" : avg >= 80 ? "50%장학생" : "노력";

		System.out.println("** 입력하신 정보 결과 **");
		System.out.println("* 이름: " + name);
		System.out.println("* Java: " + java + "점");
		System.out.println("* Html: " + html + "점");
		System.out.println("* Spring: " + spring + "점");
		System.out.println("* 총점: " + sum + "점");
		System.out.printf("* 평균: %5.1f점\n", avg);
		System.out.println("* 등급: " + grade);
		System.out.println("결과: " + (avg < 70 || java < 50 || html < 50 || spring < 50 ? "불합격입니다." : "합격입니다."));
		
	}

}
