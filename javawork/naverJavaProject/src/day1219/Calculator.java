package day1219;

public class Calculator {
	// 반환 값 없는 메소드
	void powerOn() {
		System.out.println("전원 ON");
	}

	void powerOff() {
		System.out.println("전원 OFF");
	}

	// 인자를 받고 결과 값을 반환하는 메소드
	int plus(int x, int y) {
		return x + y;
	}

	double divide(int x, int y) {
		return (double) x / y;
	}

}
