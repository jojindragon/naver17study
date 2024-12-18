package day1218;

public class Ex6Object {
	// 멤버 변수&상수 선언 영역
	static int x = 10; // static - 인스턴스 변수 없이도 접근 가능
	static int y = 20;

	// 메서드 - [반환형] : 자료형 || void - return 값이 자료형 || X
	public static void showTitle() {
		System.out.println("클래스 공부");
		System.out.println("static 변수 접근 가능: " + x + "," + y);
	}

	public static void main(String[] args) {
		// static 변수는 클래스 명으로 접근
		System.out.println("x=" + Ex6Object.x);
		System.out.println("x=" + x); // 같은 클래스 멤버라 생략 가능

		// static 변수 x+y
		int sum = x + y;
		System.out.println("sum=" + sum);

		Ex6Object.showTitle();
		showTitle(); // 멤버 변수와 같은 원리
	}

}
