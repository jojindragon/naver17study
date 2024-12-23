package day1223;

class Tire {
	public void roll() {
		System.out.println("회전");
	}
}

class HankookTire extends Tire {
	@Override
	public void roll() {
		System.out.println("회전~ 회오리");
	}
}

class KumhoTire extends Tire {
	@Override
	public void roll() {
		System.out.println("금호 타이어 회전");
	}
}

class Car {
	public Tire tire;

	public void run() {
		tire.roll();
	}
}

public class Book317 {

	public static void MyCar(Tire tire) {
		tire.roll();
	}

	public static void main(String[] args) {
		// 교재 317~318 - 다형성
		Car myCar = new Car();

		myCar.tire = new Tire();
		myCar.run();

		myCar.tire = new HankookTire();
		myCar.run();

		myCar.tire = new KumhoTire();
		myCar.run();
		System.out.println("=".repeat(15));

		MyCar(new Tire());
		MyCar(new HankookTire());
		MyCar(new KumhoTire());
	}

}
