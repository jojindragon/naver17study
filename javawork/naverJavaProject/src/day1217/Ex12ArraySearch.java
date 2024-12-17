package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		// 검색할 성씨를 입력하고 그 멤버들을 출력
		String[] member = { "강호동", "김태희", "손미나", "이지혜",
				"송중기", "김사랑", "손석구", "박미나", "강리나", "김신" };
		Scanner sc = new Scanner(System.in);
		String name;
		int cnt;

		System.out.println("== 사람 찾기2 ==");
		while (true) {
			cnt = 0;

			System.out.print("검색할 성씨(종료-exit): ");
			name = sc.nextLine();

			if (name.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				break;
			}

			for (int i = 0; i < member.length; i++) {
				if (member[i].startsWith(name)) {
					cnt++;
					System.out.println(member[i]);
				}
			}
			System.out.println("총 " + cnt + "명 검색");

			if (cnt == 0)
				System.out.println("여기에는 \"" + name + "\"씨 성은 없다.");

		}
	}

}
