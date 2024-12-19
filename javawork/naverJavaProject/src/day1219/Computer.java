package day1219;

public class Computer {
	// 가변 길이 매개변수 메소드
	int sum(int... values) {
		int sum = 0;

		for (int i = 0; i < values.length; i++)
			sum += values[i];

		return sum;
	}
}
