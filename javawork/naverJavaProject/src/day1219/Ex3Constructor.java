package day1219;
/*
 * 생성자
 * 1. 객체 생성 시 자동호출
 * 2. 리턴 타입 X - 형식: [접근지정자] 클래스명
 * 3. 오버로딩(overloading) 가능
 * 4. 주로 멤버변수 초기화를 담당 - getter/setter와 별개로
 */

class Apple {

	Apple() { // parameter X
		System.out.println("default 생성자");
	}

	Apple(String name) {
		System.out.println(name + " 인자로 받음");
	}

	Apple(int age) {
		System.out.println(age + " 인자로 받음");
	}

	Apple(String name, int age) {
		System.out.println(name + ", " + age + " 인자로 받음");
	}

}

public class Ex3Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1 = new Apple(); // 생성자 자동 호출
		Apple a2 = new Apple("a2");
		Apple a3 = new Apple(123);
		Apple a4 = new Apple("생성자", 9999);

	}

}
