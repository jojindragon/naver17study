package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {

	public static void dataInput(Student s) {
		Scanner sc = new Scanner(System.in);

		System.out.print("학생 이름: ");
		String name = sc.nextLine();
		System.out.print("학생 주소: ");
		String addr = sc.nextLine();
		System.out.print("학생 혈액형: ");
		String blood = sc.nextLine();

		s.changeStudent(name, addr, blood);
		System.out.println();
	}

	public static void showTitle() {
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}

	public static void writeStudent(Student s) {
		System.out.println(s.getName() + "\t" + s.getBlood().toUpperCase() + "형\t" + s.getAddress());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p;
		Student[] s;

		System.out.print("입력할 인원 수: ");
		p = Integer.parseInt(sc.nextLine());
		s = new Student[p]; // 메모리 할당

		for (int i = 0; i < s.length; i++) {
			s[i] = new Student(); // 생성
			dataInput(s[i]);
		}

		showTitle();

		for (Student stu : s) {
			writeStudent(stu);
		}

	}

}
