package day1220;

class Parent1 {
	public void process() {
		System.out.println("기본 작업");
	}
}

class My1 extends Parent1 {
	@Override
	public void process() {
		super.process();
		System.out.println("벽지 작업");
	}
}

class My2 extends Parent1 {
	@Override
	public void process() {
		super.process();
		System.out.println("바닥 작업");
	}
}

public class Ex5Inheri {

	public static void homeProcess(My1 my) {
		// 이 경우 My1 밖에 못 보냄 - 이런 경우 sub 클래스 하나만 보낼 수 있음
		my.process();
	}

	public static void homeProcess2(My2 my) {
		// 이 경우 My2 밖에 못 보냄
		my.process();
	}

	public static void homeProcessAll(Parent1 p) {
		// Parent 자신부터 해서 이것을 구현한 모든 sub 클래스 다 가능
		p.process();
		System.out.println();
	}

	public static void main(String[] args) {
		My1 my1 = new My1();
		My2 my2 = new My2();

		homeProcess(my1);
		homeProcess2(my2);
		System.out.println("=".repeat(15));

		// 다형성 처리
		Parent1 p1 = null;
		p1 = new My1();
		p1.process(); // My1의 메서드 호출

		p1 = new My2();
		p1.process(); // My2의 메서드 호출
		System.out.println();

		homeProcessAll(new My1());
		homeProcessAll(new My2());
		homeProcessAll(new Parent1());

	}

}
