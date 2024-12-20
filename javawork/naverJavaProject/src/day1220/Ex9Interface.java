package day1220;
/*
 * 실체 없이 메뉴목록만 있는 메뉴판과 같음
 * 추상메소드&상수만 정의 가능
 * abstract | final <- 생략
 */

interface InterA {
	public void process();
}

class SubInter implements InterA {
	@Override
	public void process() {
		System.out.println("sub 클래스 process");
	}
}

public class Ex9Interface {

	public static void process(InterA inter) {
		inter.process();
	}

	public static void main(String[] args) {
		// 부모로 선언하고 자식으로 생성
		InterA i = new SubInter();
		i.process();

		// 메소드 호출
		process(new SubInter());

	}

}
