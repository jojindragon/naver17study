package day1211;

public class Ex2DataType {

	public static void main(String[] args) {
		int kor = 90;
		int eng = 93;
		System.out.println("합계="+kor+eng); // 묵시적 형벼노한으로 String 결과 >> 합계=9093
		System.out.println("합계="+(kor+eng)); // 합계=183
		
		//진법 변환
		int a = 056; // 8진수 0??
		int b = 0x12a; // 16진수 0x??
		System.out.println("a="+a); // 10진수로 변환되어 출력 - 56
		System.out.println("b="+b); // 298
		
	}
}
