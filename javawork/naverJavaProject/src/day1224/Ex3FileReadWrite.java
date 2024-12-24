package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3FileReadWrite {

	static final String FILENAME = "./src/day1224/member.txt";

	public static void fileRead() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			// 제목
			System.out.println("\t 전체 멤버 명단");
			System.out.println();
			System.out.println("번호\t이름\t나이\t주거지");
			System.out.println("=".repeat(30));

			int n = 0;
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				// 요소마다 분리 - 이름,나이,주거지
				String[] m = line.split(",");
				System.out.println(++n + "\t" + m[0] + "\t" + m[1] + "세\t" + m[2]);
			}
			System.out.println();

		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Not Found File: " + e.getMessage());
		} finally {
			if (br != null)
				br.close();

			if (fr != null)
				fr.close();
		}

	}

	public static void fileSave() throws IOException {
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		String name, age, addr;

		fw = new FileWriter(FILENAME, true); // 추가 모드

		System.out.print("추가할 이름: ");
		name = sc.nextLine();
		System.out.print("나이: ");
		age = sc.nextLine();
		System.out.print("주거지: ");
		addr = sc.nextLine();

		// 파일 추가
		fw.write(name + "," + age + "," + addr + "\n");

		// 파일 닫기
		if (fw != null)
			fw.close();
		System.out.println();

	}

	public static void fileDelete() {
		// 파일 삭제
		File file = new File(FILENAME);
		if (file.exists()) {
			System.out.println("파일을 삭제 - 모든 멤버가 삭제");
			if (file.delete()) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
		} else {
			System.out.println("삭제할 파일이 없다.");
		}
		System.out.println();
	}

	public static int getMenu() {
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 멤버 추가\t2. 전체 출력\t3.전체 멤버 삭제\t4. 종료");
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// 문자가 들어오면 전체 출력으로 간주
			menu = 2;
		}

		return menu;
	}

	public static void main(String[] args) throws IOException {
		// 파일 읽고 쓰기
		while (true) {
			switch (getMenu()) {
			case 1 -> fileSave();
			case 2 -> fileRead();
			case 3 -> fileDelete();
			default -> {
				System.out.println("** 프로그램 종료 **");
				System.exit(0); // 시스템 정상 종료
			}
			}
		}
	}

}
