package day1220;

abstract class Test1 {
	abstract public void play();
}

abstract class Test2 extends Test1 {
	abstract public void job();
}

class Test3 extends Test2 {
	@Override
	public void play() {
		System.out.println("노는게 제일 좋아.");
	}

	@Override
	public void job() {
		System.out.println("엄숙한 근무");
	}
}

public class Ex8Abstract {

	public static void hello1(Test1 t1) {
		t1.play();
		System.out.println();
	}

	public static void hello2(Test2 t2) {
		t2.play();
		t2.job();
		System.out.println();
	}

	public static void main(String[] args) {
		hello1(new Test3());
		hello2(new Test3());

	}

}
