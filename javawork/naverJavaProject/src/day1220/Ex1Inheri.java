package day1220;

class SuperObj1 {
	SuperObj1() {
		System.out.println("super 생성자");
	}

	SuperObj1(String msg) {
		System.out.println("super 메시지 받는 생성자: " + msg);
	}
}

class SubObj1 extends SuperObj1 {
	SubObj1() {
		super(); // 부모의 디폴트 생성자 호출 - 생략 가능
		System.out.println("sub 생성자");
	}

	SubObj1(String msg) {
		super(msg);
		System.out.println("sub 2번째 생성자");
	}
}

public class Ex1Inheri {

	public static void main(String[] args) {
		SubObj1 sub1 = new SubObj1(); // 상속관계여서 부모도 호출
		SubObj1 sub2 = new SubObj1("Hello"); //

	}

}
