package day1219;

import java.util.Scanner;

public class Ex1ObjectArray {
	Student[] stuArray = new Student[3]; // 메모리 할당 - 초기값 null

	public void inputData() {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < stuArray.length; i++) {
			stuArray[i] = new Student();

			System.out.print("학생 이름: ");
			String name = sc.nextLine();
			System.out.print("혈액형: ");
			String blood = sc.nextLine();
			System.out.print("태어난 년도: ");
			int birthYear = Integer.parseInt(sc.nextLine());
			System.out.print("점수: ");
			int score = Integer.parseInt(sc.nextLine());
			System.out.println("-".repeat(10));

			stuArray[i].setName(name);
			stuArray[i].setBlood(blood);
			stuArray[i].setBirthYear(birthYear);
			stuArray[i].setScore(score);
		}
	}

	public static void showTitle() {
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(50));
	}

	public void writeDataArray() {
		for (Student s : stuArray) {
			System.out.println(s.getName() + "\t" + s.getBlood().toUpperCase() + "형\t" + s.getAge() + "\t"
					+ s.getScore() + "점\t" + s.getScoreGrade());
		}
	}

	public static void main(String[] args) {
		//
		Ex1ObjectArray ex1 = new Ex1ObjectArray();
		ex1.inputData();

		showTitle();

		ex1.writeDataArray();

	}

}
