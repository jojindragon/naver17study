package day1224;

import java.io.File;

public class Ex2File {

	public static void main(String[] args) {
		// File 객체
		File file1 = new File("./score.txt");
		File file2 = new File("../../javawork");

		// 글자길이 - byte 단위
		System.out.println(file1.length());

		// 가능 여부 묻기 - 권한(삭제/읽기/쓰기)
		System.out.println(file1.canExecute()); // true
		System.out.println(file1.canRead()); // true
		System.out.println(file1.canWrite()); // true

		System.out.println(file1.exists()); // 파일 존재하면 true

		// 디렉토리인가?
		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());

		// File인가?
		System.out.println(file1.isFile());
		System.out.println(file2.isFile());

		// 디렉토리라면 목록 출력
		if (file1.isDirectory()) {
			System.out.println("** File1 목록 **");
			String[] list = file1.list();
			for (String s : list)
				System.out.print(s + "\t");
			System.out.println();
		} else {
			System.out.println("file1: 파일입니다.");
		}

		if (file2.isDirectory()) {
			System.out.println("** File2 목록 **");
			String[] list = file2.list();
			for (String s : list)
				System.out.print(s + "\t");
			System.out.println();
		} else {
			System.out.println("file2: 파일입니다.");
		}
		System.out.println("=".repeat(30));

		// 경로 포함 파일명
		System.out.println(file1.getAbsolutePath()); // 절대경로
		System.out.println(file1.getPath()); // 상대 경로
		System.out.println(file1.getName()); // 파일명만

	}

}
