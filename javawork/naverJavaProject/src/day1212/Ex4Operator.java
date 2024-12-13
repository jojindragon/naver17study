package day1212;

public class Ex4Operator {

	public static void main(String[] args) {
		// 관계 연산자와 논리 연산자
		int kor = 89, eng = 100, mat = 89;
		boolean f = false;

		System.out.println(kor > eng);
		System.out.println(kor < eng);
		System.out.println(kor == mat);
		System.out.println(kor != mat);
		System.out.println(kor > eng && ++eng > mat);
		System.out.println(kor > eng || eng > mat);
		System.out.println(!(kor > eng));
		System.out.println(!f);
		System.out.println(eng);
	}

}
