package day1223;

interface InterA {
	public void study();
}

interface InterB extends InterA { // 인터페이스 간 상속: extends
	public void play();
}

class MyInter implements InterB { // 클래스&인터페이스 간 관계: implements
	@Override
	public void play() {
		System.out.println("그룹 스터디를 합니다.");
	}

	@Override
	public void study() {
		System.out.println("그룹 모임을 합니다.");
	}

	public void job() {
		System.out.println("밀린 일처리를 합니다.");
	}
}

public class Ex1InterfaceInheri {

	public static void main(String[] args) {
		// 호출 가능한 범위 확인
		InterA interA = new MyInter();
		interA.study();
		System.out.println("=".repeat(20));

		InterB interB = new MyInter();
		interB.study();
		interB.play();
		System.out.println("=".repeat(20));

		MyInter my = new MyInter();
		my.study();
		my.play();
		my.job();
		System.out.println("=".repeat(20));

		// 다운캐스팅으로 job 호출
		((MyInter) interB).job();
		((MyInter) interA).job();

	}

}
