package day1213;

public class Ex11For {

	public static void main(String[] args) {
		System.out.println("알파벳 반복 출력");
		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i);
		}
		System.out.println();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		System.out.println();

		for (int i = 122; i >= 97; i--) {
			System.out.print((char) i);
		}
		System.out.println();
		for (char ch = 'z'; ch >= 'a'; ch--) {
			System.out.print(ch);
		}
	}

}
