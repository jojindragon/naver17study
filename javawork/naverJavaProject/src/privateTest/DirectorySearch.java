package privateTest;

import java.io.File;
import java.util.Scanner;

public class DirectorySearch {

	public static void directorySearch(File directory, String keyword) {
		// 유효한 디렉토리인지 확인
		if (!directory.isDirectory()) {
			System.out.println(directory.getAbsolutePath() + " : 디렉토리가 아니다");
			return;
		}

		// 디렉토리 내 파일 & 디렉토리 목록 가져오기
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				// 서브 디렉토리 - 재귀적 탐색
				if (file.isDirectory())
					directorySearch(file, keyword);
				else {
					// 파일명에 키워드가 포함되었는가
					if (file.getName().toLowerCase().contains(keyword.toLowerCase()))
						System.out.println("발견: " + file.getAbsolutePath());
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Mac&Linux - /
		// Window - C:/
		// 검색할 디렉토리 경로
		System.out.print("검색을 시작할 디렉토리 경로: ");
		String startPath = sc.nextLine();

		// 키워드 입력
		System.out.print("검색할 디렉토리 키워드: ");
		String keyword = sc.nextLine();

		// 검색 시작
		File startDirectory = new File(startPath);
		if (startDirectory.exists())
			directorySearch(startDirectory, keyword);
		else
			System.out.println("특정 디렉토리는 존재하지 않는다.");

		sc.close();

	}

}
