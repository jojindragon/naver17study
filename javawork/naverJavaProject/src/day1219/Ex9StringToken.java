package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// | 로 분리해서 출력
		// split으로는 분리 X - ,는 잘 잡음
		String msg1 = "red|green|yellow|white|black";
		String[] arr1 = msg1.split("|");
		for (String a : arr1)
			System.out.println(a);

		String msg2 = "red,green,yellow,white,black";
		String[] arr2 = msg2.split(",");
		for (String a : arr2)
			System.out.println(a);

		// StringTokenizer
		// 분리할 문자열, 분릭 기준 문자
		StringTokenizer st = new StringTokenizer(msg1, "|");
		System.out.println("\n분리할 총 토큰 수: " + st.countTokens());

		// 이 경우 다 출력 X
		// countToken()은 nextToken()으로 읽고 남은 토큰 수를 부르기 때문
		// 토큰을 읽을 때마다 갯수 감소
		// 즉, 따로 미리 처음 토큰 수를 저장하고 사용하는 것이 맞음
//		for (int i = 0; i < st.countTokens(); i++)
//			System.out.println(st.nextToken());

		int n = st.countTokens();
		for (int i = 0; i < n; i++)
			System.out.println(st.nextToken());
		System.out.println();

		StringTokenizer st2 = new StringTokenizer(msg1, "|");
		while (st2.hasMoreTokens()) // 토큰이 존재하는 동안
			System.out.println(st2.nextToken());
		System.out.println();

		String[] arr3 = msg1.split("\\|"); // 정규 표현식 \\
		for (String a : arr3)
			System.out.println(a);
		System.out.println();

		// 아래 데이터를 .으로 분리해 출력 - split으로 하기
		String msg3 = "이미자.손태영.강호동.이영자.박진아";
		String[] arr4 = msg3.split("\\.");
		for (String a : arr4)
			System.out.println(a);
		System.out.println("총 개수: " + arr4.length);

	}

}
