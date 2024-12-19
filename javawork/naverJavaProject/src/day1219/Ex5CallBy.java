package day1219;
/*
 * 인자전달 방식
 * Call By Value - 값만 전달 [기본형, String]
 * Call By Reference - 주소가 전달 [모든 객체, 배열 타입]
 */

class Test {
	String message;
	int code;
}

public class Ex5CallBy {

	public static void changeInt(int n) { // 주소가 다르게 새로 생성
		n = 200;
	}

	public static void changeString(String s) {
		s = "변해라!";
	}

	public static void changeTest(Test t) {
		t.message = "Happy";
		t.code = 100;
	}

	public static void changeArray(int[] arr) {
		arr[1] = 20;
	}

	public static int changeScore(int score) {
		if (score >= 80)
			return score;
		else
			return 90;
	}

	public static void main(String[] args) {
		int n = 100;
		changeInt(n); // 안 바뀜 - 값만 전달
		System.out.println("n=" + n);

		String s = "Apple";
		changeString(s); // 값만 전달
		System.out.println("s: " + s);

		// 객체의 경우
		Test t = new Test();
		System.out.println("message= " + t.message + ", code=" + t.code);
		changeTest(t); // 주소가 전달 - 값이 바뀜
		System.out.println("message= " + t.message + ", code=" + t.code);

		int[] arr = { 0, 0, 0 };
		changeArray(arr); // 주소가 전달
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();

		// 전달되는 형식으로 변환(값 -> return으로 반환)
		int score = 70;
		System.out.println("score: " + score);
		score = changeScore(score);
		System.out.println("score: " + score);

	}

}
