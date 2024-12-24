package team;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TeamArray {

	public static void main(String[] args) {
		// Study 그룹 짜기
		Scanner sc = new Scanner(System.in);
		String[] member = { "꽝", "김녹엽", "김동휘", "김준호", "박서희", "박수진", "백성현", "서지훈", "오하늬", "이원재", "이재호", "이재희", "장진욱",
				"전세호", "전종원", "조진용", "채원석", "채원웅", "최은영", "최준혁" };
		int[] rnd = new int[20];
		String[][] team;
		String title;
		int teamInwon, teamCnt;

		System.out.print("팀 제목 입력: ");
		title = sc.nextLine();
		System.out.print("한 팀 당 인원수 입력: ");
		teamInwon = sc.nextInt();
		teamCnt = 20 / teamInwon; // 총 팀 갯수

		// team 메모리 할당
		team = new String[teamCnt][teamInwon];

		// rnd 에 0~19의 중복되지 않은 숫자 할당
		for (int i = 0; i < rnd.length; i++) {
			rnd[i] = (int) (Math.random() * 20);
			for (int j = 0; j < i; j++)
				if (rnd[i] == rnd[j]) {
					i--;
					break;
				}
		}

		// 금일 날짜 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE)");
		System.out.println("\t**" + title + "(" + sdf.format(new Date()) + ")**");
		System.out.println();

		// team 에 rnd 순서대로 이름 할당
		int idx = 0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team[i].length; j++)
				team[i][j] = member[rnd[idx++]];
		}

		// 출력
		for (int i = 0; i < team.length; i++) {
			System.out.print("[" + (i + 1) + "조] : ");
			for (int j = 0; j < team[i].length; j++) {
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print(team[i][j] + "  ");
			}
			System.out.println();
		}

	}

}
