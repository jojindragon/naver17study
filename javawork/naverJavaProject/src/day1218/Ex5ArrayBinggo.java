package day1218;

import java.util.Scanner;

public class Ex5ArrayBinggo {

	public static void main(String[] args) {
		// 빙고 출력
		// 난수 1~3, 엔터 - 다시 난수, q/Q - 종료
		Scanner sc = new Scanner(System.in);
		int[][] puzzle = new int[3][3];
		int binggo;

		System.out.println("== 빙고 게임 ==");
		while (true) {
			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++)
					puzzle[i][j] = (int) (Math.random() * 3) + 1;
			}

			for (int i = 0; i < puzzle.length; i++) {
				for (int j = 0; j < puzzle[i].length; j++)
					System.out.printf("%3d", puzzle[i][j]);
				;
				System.out.println();
			}

			binggo = 0;
			for (int i = 0; i < puzzle.length; i++) {
				int row = puzzle[i][0];
				int col = puzzle[0][i];
				// 가로
				if (row == puzzle[i][1] && row == puzzle[i][2])
					binggo++;

				// 세로
				if (col == puzzle[1][i] && col == puzzle[2][i])
					binggo++;
			}
			// 대각선
			if (puzzle[1][1] == puzzle[0][0] && puzzle[1][1] == puzzle[1][1])
				binggo++;

			if (puzzle[1][1] == puzzle[0][1] && puzzle[1][1] == puzzle[1][0])
				binggo++;

			//출력
			if (binggo == 0)
				System.out.println("\t꽝!!!");
			else
				System.out.println("\t빙고: " + binggo + "개");

			if (sc.nextLine().equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println("-".repeat(20));

		}
	}

}
