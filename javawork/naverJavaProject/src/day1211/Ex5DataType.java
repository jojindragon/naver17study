package day1211;

public class Ex5DataType {

	public static void main(String[] args) {
		// 자바는 char 타입이 2바이트 >> 한글 1글자도 저장 가능
		char ch1 = 'A';
		char ch2 = '가';
		
		System.out.println("ch1="+ch1);
		System.out.println("ch2="+ch2);
		// 문자열: %s, 문자: %c
		System.out.printf("ch1=%c \t ch2=%c \n", ch1, ch2);
		System.out.printf("ch1=%d \t ch2=%d \n", (int)ch1, (int)ch2); // 아스키 코드(ASCII Code)
		System.out.printf("%c %c %c %c %c\n", 72, 101, 108, 108, 111); // H e l l o
	}

}
