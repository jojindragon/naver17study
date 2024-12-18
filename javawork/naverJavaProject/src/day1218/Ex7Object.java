package day1218;

class Apple {
	// 접근지정자 생략 시 default - 같은 패키지 내에서는
	// private 제외하고 모두 직접 접근 가능
	static String message = "Hello"; // 클래스 멤버 변수
	static final String EMP = "비트캠프"; // 상수
	String name = "Candy"; // 인스턴스 멤버 변수

}

public class Ex7Object {

	public static void main(String[] args) {
		// 클래스가 달라 클래스명 생략 불가 - 클래스명.변수명
		System.out.println("메시지: " + Apple.message);
		System.out.println("EMP: " + Apple.EMP);

		// 값 변경 - final은 상수라 변경이 불가능하다는 에러가 나옴
		Apple.message = "Happy Day";
//		Apple.EMP = "삼성전자";
		System.out.println("메시지: " + Apple.message);
		System.out.println("EMP: " + Apple.EMP);

//		System.out.println(Apple.name); - 오류 발생		
		// 객체 생성 해줘야 함
		Apple a = new Apple();
		System.out.println("이름: " + a.name);
		a.name = "aaa";
		System.out.println("a의 이름: " + a.name);

		Apple b = new Apple();
		b.name = "bbb";
		System.out.println("b의 이름: " + b.name);
		System.out.println("a의 이름: " + a.name);

		// 클래스 변수라 b 객체로 바꿨는데도 a에서 바뀐게 나옴
		b.message = "bb";
		System.out.println("메시지 " + a.message);

	}

}
