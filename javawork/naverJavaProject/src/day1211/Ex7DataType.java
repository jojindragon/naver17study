package day1211;

/*
  * 이름 : Candy님
  * 나이 : 32세
  * 키 : 163.8Cm
  * 몸무게 : 56.7Kg
  * 혈액형 : B형 
 */

public class Ex7DataType {

	public static void main(String[] args) {
		// printf로 위와 같이 출력 해보기
		String name = "Candy";
		int age = 32;
		float height = 163.8f;
		double weight = 56.7;
		char blood = 'B';
				
		System.out.printf("* 이름\t: %6s님\n", name);
		System.out.printf("* 나이\t: %6d세\n", age);
		System.out.printf("* 키\t: %5.1fCm\n", height);
		System.out.printf("* 몸무게\t: %5.1fKg\n", weight);
		System.out.printf("* 혈액형\t: %6c형\n\n\n", blood);
		// println 버전
		System.out.println("* 이름	:  "+name+"님");
		System.out.println("* 나이	:     "+age+"세");
		System.out.println("* 키	: "+height+"Cm");
		System.out.println("* 몸무게	:  "+weight+"Kg");
		System.out.println("* 혈액형	:      "+blood+"형");
		
	}

}
