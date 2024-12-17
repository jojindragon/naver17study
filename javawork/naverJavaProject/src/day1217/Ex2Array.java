package day1217;

public class Ex2Array {

	public static void main(String[] args) {
		// 1차원 배열
		char[] ch;
		ch = new char[4];

		System.out.println("배열 크기: " + ch.length); // 이건 속성 ()X

		ch[0] = 'H';
		ch[1] = 65;
		ch[2] = 'x';
		ch[3] = '1';

		for (int i = 0; i < ch.length; i++)
			System.out.println("ch[" + i + "]=" + ch[i]);
		for (char a : ch)
			System.out.print(a);
		System.out.println();
		System.out.println("=".repeat(20));

		char[] ch2 = new char[5];
		ch2 = new char[] { 'a', 'n', 'x', 'y', 'u' }; // 따로 초기화 시 다시 new

		for (int i = 0; i < ch2.length; i++)
			System.out.println("ch2[" + i + "]=" + ch2[i]);
		System.out.println("=".repeat(20));

		char[] ch3 = { 's', 'r', 't', 'v', 'i' };
		for (char a : ch3)
			System.out.print(a);

	}

}
