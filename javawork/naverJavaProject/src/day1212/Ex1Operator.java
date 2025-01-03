package day1212;

public class Ex1Operator {

	public static void main(String[] args) {
		// 증감 연산자, ++a (전치: 1순위), a++ (후치: 끝순위)
		int a, b, m, n;
		a = b = 5;
		System.out.printf("a=%d, b=%d\n", a, b);

		m = ++a; // a 증가 > 대입
		n = b++; // b 대입 > b 증가
		System.out.printf("a=%d, b=%d, m=%d, n=%d \n=======\n", a, b, m, n);

		a = b = m = n = 5;
		m = a++ * ++b;// 5*6
		System.out.printf("a=%d, b=%d, m=%d, n=%d \n", a, b, m, n);

		// 애매모호한 연산자들은 띄어쓰기로 구분해야 함
		n = a++ + ++b; // 6+7
		System.out.printf("a=%d, b=%d, m=%d, n=%d \n=======\n", a, b, m, n);

		a = 5;
		System.out.println(a++);
		System.out.println(++a);

		a = b = m = n = 5;
		a *= b-- - ++n * 3; // (5-6*3)*5 = -65
		System.out.printf("a=%d, b=%d, m=%d, n=%d \n", a, b, m, n);

	}

}
