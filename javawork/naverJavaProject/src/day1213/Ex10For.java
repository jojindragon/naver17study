package day1213;

public class Ex10For {

	public static void main(String[] args) {
		// 나열된 숫자 출력
		for (int i = 0; i <= 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
			if (i == 5)
				break;
		}

		System.out.println();
		for (int i = 1; i <= 10; i++) {			
			if (i % 2 == 0)
				continue;
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
