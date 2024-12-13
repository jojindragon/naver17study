package day1211;

public class Ex4DataType {

	public static void main(String[] args) {
		// ????-??-?? 형식으로 출력
		int year = 2024;
		int month = 5;
		int day = 11;
				
		System.out.println(year+"-"+month+"-"+day);
		System.out.printf("%d-%02d-%02d\n", year, month, day); // 2자리보다 작을 경우 남는 곳 0으로 표기
		
		int money = 2356000;
		System.out.printf("금월 급여=%10d원\n", money);
		System.out.printf("금월 급여=%-10d원\n", money); // -는 왼쪽부터 출력(남는 공백이 뒤로 감)
	}

}
