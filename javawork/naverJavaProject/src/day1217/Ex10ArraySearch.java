package day1217;

import java.util.Scanner;

public class Ex10ArraySearch {

	public static void main(String[] args) {
		// 숫자 검색 - 존재 여부와 몇번째에 있는지 출력
		int[] data = { 12, 5, 10, 9, 16, 20, 11, 3, 7, 15 };
		Scanner sc = new Scanner(System.in);
		int searchNum;
		boolean find;

		System.out.println("== 숫자 찾기 ==");
		while (true) {
			find = false;
			System.out.print("숫자 입력(종료 0): ");
			searchNum = Integer.parseInt(sc.nextLine());

			if (searchNum == 0) {
				System.out.println("프로그램 종료");
				break;
			}

			for (int i = 0; i < data.length; i++) {
				if (searchNum == data[i]) {
					find = true;
					System.out.println((i + 1) + "번쨰에 존재");
					break;
				}
			}

			if (!find)
				System.out.println("해당 숫자 X");

		}

	}

}
