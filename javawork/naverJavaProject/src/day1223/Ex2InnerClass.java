package day1223;

class OuterObj { // 외부 클래스
	int a = 10;
	static int b = 20;
	private int c = 30;

	class InnerObj { // 내부 클래스 - 하나의 멤버로 인식
		int x = 40;
		static int y = 50; // 구버전은 내부 클래스 static이 안 됨 - jdk16부터 가능

		public void disp() {
			System.out.println("a=" + a);
			System.out.println("b=" + b);
			System.out.println("c=" + c);
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
	}

	public void outerDisp() { // 많이 쓰는 내부 클래스 호출
		InnerObj inObj = new InnerObj();
		inObj.disp();
	}
}

public class Ex2InnerClass {

	public static void main(String[] args) {
		// 호출
		OuterObj obj1 = new OuterObj();
		obj1.outerDisp();
		System.out.println();

		OuterObj.InnerObj obj2 = obj1.new InnerObj();
		obj2.disp();

	}

}
