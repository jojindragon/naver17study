package day1223;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex13FileException {

	public static void scoreRead() throws FileNotFoundException, IOException {
		FileReader fr = null; // 파일을 읽기 위함
		BufferedReader br = null; // 1줄 단위로 읽기 위함

		fr = new FileReader("./score.txt");
		System.out.println("파일 발견!!");

		br = new BufferedReader(fr);

		int sum = 0, n = 0, score;
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			try {
				score = Integer.parseInt(line);
				sum += score;
				System.out.println(++n + "번 점수: " + score);
			} catch (NumberFormatException e) {
				System.out.println("문자 존재: " + e.getMessage());
			}

		}
		System.out.println("총 합계: " + sum);

		// 생성된 역순으로 닫기 - 열린 자원 닫기
		if (br != null)
			br.close();
		if (fr != null)
			fr.close();
	}

	public static void main(String[] args) {
		// 파일 읽기
		try {
			scoreRead();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 달아났다: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("정상 종료");
	}

}
