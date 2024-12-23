package day1211;

public class Ex3DataType {

	public static void main(String[] args) {
		float F1 = 3.6f; // ??f --> 4바이트 저장
		double F2 = 5.6;
		System.out.println("F1="+F1);
		System.out.println("F2="+F2);
		
		float F3 = 2.123456789f;
		double F4 = 2.123456789;
		System.out.println("F3="+F3); // 용량 문제로 소수점 이하 6자리까지만 출력(반올림)
		System.out.println("F4="+F4); // 전부 출력

		System.out.print("a"); // 줄 개행 X
		System.out.println("b");
		System.out.println("c");
		
		// 변환기호 이용 출력 --> %5.1f : 전체 5자리, 소숫점 1자리까지
		// 제어 문자열: \n 줄넘김. \t 다음 탭, \\ 역슬래쉬 1개 출력, \" 따옴표 출력...
		System.out.printf("F3 = %5.1f\nF4 = %5.2f\n", F3, F4);
	}

}
