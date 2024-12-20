/*
 * Command 라는 인터페이스에 process() 추상 메소드 추가
 * 인터페이스 Command를 구현 
 * List(출력), Insert(추가), Delete(삭제), Update(수정) 클래스
 * 
 * 메인에서 while문을 통해 다음 같은 메뉴와 기능 구현
 * 1. 추가	2. 출력	3. 삭제	4. 수정	5. 종료
 * 
 * 1번 - 데이터가 추가되었습니다.
 * 2번 - 데이터를 출력합니다.
 * 3번 - 데이터가 삭제되었습니다.
 * 4번 - 데이터가 수정되었습니다.
 * 5번 - 프로그램을 종료합니다. -> 실제 종료
 * 
 * 호출하는 메소드 - public static void dbProcess(Command comm)
 * -> 다형성 처리가 되도록 구현
 */
package day1220;

import java.util.Scanner;

interface Command {
	public void process();
}

class List implements Command {
	@Override
	public void process() {
		System.out.println("데이터를 출력합니다.");
	}
}

class Insert implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 추가되었습니다.");
	}
}

class Delete implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 삭제되었습니다.");
	}
}

class Update implements Command {
	@Override
	public void process() {
		System.out.println("데이터가 수정되었습니다.");
	}
}

public class Ex11InterfaceQuiz {

	public static void dbProcess(Command comm) {
		comm.process();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. 추가\t2. 출력\t3. 삭제\t4. 수정\t5. 종료");
			System.out.println("=".repeat(50));
			switch (sc.nextLine()) {
			case "1" -> dbProcess(new Insert());
			case "2" -> dbProcess(new List());
			case "3" -> dbProcess(new Delete());
			case "4" -> dbProcess(new Update());
			case "5" -> {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			default -> {
				System.out.println("제대로 입력해라.");
				continue;
			}
			}

		}
	}

}
