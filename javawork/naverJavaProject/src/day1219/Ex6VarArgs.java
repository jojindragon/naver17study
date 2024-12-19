package day1219;

public class Ex6VarArgs {

	public static void writeColor(String color1) {
		System.out.println("color1=" + color1);
	}

	public static void writeColor(String color1, String color2) {
		System.out.println("color1=" + color1 + ", color2=" + color2);
	}

	public static void writeColor(String color1, String color2, String color3) {
		System.out.println("color1=" + color1 + ", color2=" + color2 + ", color3=" + color3);
	}

	public static void writeName(String... name) {
		// 배열 타입으로 들어온다.
		System.out.println("name 길이: " + name.length);
		if (name.length == 0)
			System.out.println("빈 성채");
		else {
			System.out.println("** 멤버 목록 **");
			for (String s : name)
				System.out.println(s + "\t");
			System.out.println("=".repeat(20));
		}

	}

	public static void main(String[] args) {
		// 오버로딩 - 정해진 거 이상 못 보냄
		writeColor("red");
		writeColor("yellow", "green");
		writeColor("white", "orange", "black");

		// 여러 문자열 보내기
		System.out.println("Variable Arguments 기능을 이용");
		writeName("aa");
		writeName("aa", "bb");
		writeName("a", "aa", "bb", "abab");
		writeName();
	}

}
