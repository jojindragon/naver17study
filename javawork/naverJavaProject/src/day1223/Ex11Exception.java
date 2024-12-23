package day1223;

import java.io.FileWriter;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) {
		// 일반 Exception - 선택이 아닌 필수로 처리
		// 메소드 자체가 throws로 던지는 Exception 처리
		System.out.println("3초만 대기");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("3초 국룰");

		// 파일에 이름&주소를 저장
		FileWriter fw = null;

		try {
//			fw = new FileWriter("./memo1223.txt"); // 새로 생성 - 덮어쓰기
			fw = new FileWriter("./memo1223.txt", true); // 연이어서 쓰기
			fw.write("이름: 1223 수업\n");
			fw.write("주소: 강남구 비트캠프\n");
			fw.write("=".repeat(15) + "\n");
			System.out.println("탐색기로 파일 확인");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}

		System.out.println("정상 종료");

	}

}
