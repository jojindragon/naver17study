package day1220;

// 추상 클래스 - 객체 생성은 불가 - new 불가
// 자식 클래스가 반드시 구현할 목적으로 추상 메소드 생성
abstract class Parent2 {
	// 부모에서 메소드 구현을 안 함, 선언만 해 놓음 - 오버라이드를 위함
	// 이떄 쓰는 것이 abstract 메소드 - C는 virtual 클래스란 개념
	abstract public void process(); // 추상 메소드 - 일반 메소드에서 선언 불가

	// 추상 메소드만이 아닌 일반 메소드도 구현 가능
	public void study() {
		System.out.println("JAVA 공부");
	}

}

class Your1 extends Parent2 {
	@Override
	public void process() {
		System.out.println("벽지 공사");
	}
	
	// Your1이 가진 메소드 - 오버라이드 X
	public void draw() {
		System.out.println("그림 그리기");
	}
	
}

class Your2 extends Parent2 {
	@Override
	public void process() {
		System.out.println("타일 공사");
	}
	
}

public class Ex6Abstract {

	public static void yourProcess(Parent2 p) {
		p.process();
		p.study();
		
//		p.draw(); - 오류 발생
//		((Your1)p).draw(); // 다운캐스팅 후 호출하면 가능, 단 이 경우 같은 자식 클래스인 Your2가 인자로 오면 오류 발생
		System.out.println("=".repeat(5));
	}

	public static void main(String[] args) {
		yourProcess(new Your1());
		yourProcess(new Your2());

	}

}
