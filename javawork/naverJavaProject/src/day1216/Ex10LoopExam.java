package day1216;

public class Ex10LoopExam {

	public static void main(String[] args) {
		// 구구단 출력...
		for (int i = 2; i <= 9; i++)
			System.out.printf("[%d단]\t", i);
		System.out.println();
		System.out.println("=".repeat(65));
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d=%d\t", j, i, i * j);
			}
			System.out.println();
		}

	}

}
