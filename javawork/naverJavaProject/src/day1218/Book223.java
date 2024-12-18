package day1218;

public class Book223 {
	public static void showKorean(Korean k) {
		System.out.println("name: " + k.name);
		System.out.println("nation: " + k.nation);
		System.out.println("ssn: " + k.ssn);
		System.out.println("-".repeat(10));
	}

	public static void main(String[] args) {
		// 교재 223 - 필드 초기화
		Korean k1 = new Korean("aaa", "00000101-XXXXXXX");
		Korean k2 = new Korean("bbb", "20241231-XXXXXXX");
		showKorean(k1);
		showKorean(k2);
	}

}
