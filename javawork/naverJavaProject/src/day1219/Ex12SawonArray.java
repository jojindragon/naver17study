package day1219;

import java.util.Scanner;

/*
 * showTitle - 제목 출력
 * 사원명	직급	기본급	수당	가족수당	세금	실수령액
 * 
 *  wirteSawon(Sawon sawon) - 1개의 데이터 출력
 *  
 *  인원수 입력 후 인원 수만큼 배열 메모리 할당
 *  
 *  배열에 데이터 입력 후 생성자 통해서 데이터 저장
 *  
 *  - 제목 출력
 *  - 반복문으로 데이터 출력하는 메소드 호출
 */

public class Ex12SawonArray {

	public static void showTitle() {
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}

	public static void writeSawon(Sawon s) {
		System.out.println(s.getSawonName() + "\t" + s.getPosition() + "\t" + s.getGibonPay() + "\t" + s.getSudang()
				+ "\t" + s.getFamSudang() + "\t" + s.getTax() + "\t" + s.getNetPay());
	}

	public static void main(String[] args) {
		// 12/19 총 정리 문제
		Scanner sc = new Scanner(System.in);
		int inwon;
		Sawon[] mySawon;

		// 메모리 할당
		System.out.print("총 사원 수: ");
		inwon = Integer.parseInt(sc.nextLine());
		mySawon = new Sawon[inwon];

		// 생성자 생성
		System.out.println("사원 정보 입력");
		System.out.println("-".repeat(15));
		for (int i = 0; i < inwon; i++) {
			System.out.print("사원 이름: ");
			String name = sc.nextLine();
			System.out.print("직급: ");
			String pos = sc.nextLine();
			System.out.print("가족 수: ");
			int famSu = Integer.parseInt(sc.nextLine());

			mySawon[i] = new Sawon(name, pos, famSu);
			System.out.println("-".repeat(15));
		}

		// 제목
		showTitle();

		// 출력
		for (Sawon s : mySawon)
			writeSawon(s);
	}

}
