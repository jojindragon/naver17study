package day1216;

public class Ex9LoopExam {

	public static void main(String[] args) {
		// 삼각형
		System.out.println("=".repeat(15));
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 역삼각형
		System.out.println("=".repeat(15));
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 피라미드
		System.out.println("=".repeat(15));
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
