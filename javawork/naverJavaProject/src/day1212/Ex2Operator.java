package day1212;

public class Ex2Operator {

	public static void main(String[] args) {
		// 산술 연산자
		int v1 = 11;
		int v2 = 4;

		System.out.println(v1 + v2);
		System.out.println(v1 - v2);
		System.out.println(v1 * v2);
		System.out.println(v1 / v2);
		System.out.println((double) v1 / v2);
		System.out.println(v1 % v2);

		int money = 3456789;
		System.out.println("금액 : " + money + "원");
		System.out.println("만원 : " + money / 10000 + "장");
		System.out.println("만원 : " + money % 10000 / 1000 + "장");
		System.out.println("만원 : " + money % 1000 / 100 + "개");
		System.out.println("잔액 : " + money % 100 + "원");

	}

}
