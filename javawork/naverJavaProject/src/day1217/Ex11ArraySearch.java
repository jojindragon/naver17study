package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		// 이름을 입력하면 몇번째에 있는지 출력, 없으면 없다.
		String[] member = { "강호동", "김태희", "손미나", "이지혜",
				"송중기", "김사랑", "손석구", "박미나", "강리나", "김신" };
		Scanner sc = new Scanner(System.in);
		String name;
		boolean find;

		System.out.println("== 사람 찾기 ==");
		while (true) {
			find = false;
			System.out.print("이름(종료 - 종료): ");
			name = sc.nextLine();

			if (name.equals("종료")) {
				System.out.println("프로그램 종료");
				break;
			}

			for (int i = 0; i < member.length; i++) {
				if (name.equals(member[i])) {
					find = true;
					System.out.println((i + 1) + "번쨰 사람");
					break;
				}
			}

			if (!find)
				System.out.println("누구세오?");

		}

	}

}
