package day1219;

public class Ex7VarArgs {

	public static int clacNum(int... n) {
		int sum = 0;

		System.out.println("총 " + n.length + "개의 점수");
		for (int score : n) {
			System.out.print(score + " ");
			sum += score;
		}
		System.out.println();

		return sum;
	}

	public static void main(String[] args) {
		int s1 = clacNum(90, 80);
		System.out.println("합계 = " + s1);

		int s2 = clacNum(90, 80, 100, 67, 77);
		System.out.println("합계 = " + s2);

		int s3 = clacNum(56, 78, 90, 12, 34, 88, 100, 99);
		System.out.println("합계 = " + s3);

	}

}
