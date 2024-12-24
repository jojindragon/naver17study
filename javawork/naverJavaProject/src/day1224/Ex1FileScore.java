package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {

	public static void scoreRead() {
		FileReader fr = null;
		BufferedReader br = null;

		int cnt = 0, sum = 0;
		double avg;

		// 생성
		try {
			fr = new FileReader("./score.txt");
			System.out.println("파일 존재!");
			br = new BufferedReader(fr);

			while (true) {
				// 파일에서 1줄씩 읽기
				String s = br.readLine();

				// null을 만나면 - 읽을 게 없으면 break
				if (s == null)
					break;

				try {
					int score = Integer.parseInt(s);
					cnt++;
					sum += score;
					System.out.println(cnt + "번째 => " + score + "점");
				} catch (NumberFormatException e) {
					System.out.println("\t 문자가 포함!");
				}
			}

			// 평균
			avg = (double) sum / cnt;
			System.out.println("=".repeat(15));
			System.out.println("점수 갯수: " + cnt);
			System.out.println("총점: " + sum);
			System.out.println("평균: " + avg);

		} catch (FileNotFoundException e) {
			System.out.println("Not Found File: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("** 정상 종료 **");
	}

	public static void main(String[] args) {
		scoreRead();
	}

}
