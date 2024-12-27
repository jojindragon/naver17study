package day1227;

/*
 * 자바에서의 함수형 프로그램 - 람다(Lamda) 표현식
 * 인터페이스를 사용하는 익명 내부 클래스의 또다른 표현식
 * 단, 인터페이스는 단 하나의 추상 메소드만 소유
 * 
 * 그리스어 알파벳의 11번째 글자
 */

@FunctionalInterface // 메소드가 하나인지 아닌지 검증하는 역할, 2개 이상 오류
interface Orange {
	public void write();
//	public void study(); 
}

@FunctionalInterface
interface DataAdd {
	public void add(int x, int y);
}

public class Ex2Lambda {

	Orange or = new Orange() { // 기존 익명 내부 클래스 형태의 구현

		@Override
		public void write() {
			System.out.println("오렌 지병 익명 내부 클래스 형태");
		}
	};

	// 람다식 호출법
	public void lambdaMethod() {
		Orange or1 = () -> System.out.println("람다식 메소드 호출");
		or1.write();

		Orange or2 = () -> System.out.println("오렌 지병");
		or2.write();

		DataAdd da = (int x, int y) -> System.out.println(x + "+" + y + "=" + (x + y));
		da.add(10, 20);
		da.add(3, 5);

	}

	public static void main(String[] args) {
		Ex2Lambda ex2 = new Ex2Lambda();
		ex2.or.write();

		ex2.lambdaMethod();

	}

}
