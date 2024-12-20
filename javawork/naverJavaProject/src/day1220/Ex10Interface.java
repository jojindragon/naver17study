package day1220;

interface InterB {
	int SPEED = 100; // final 상수 - 변경 불가

	public void speedWrite();

	public void speedUp(int speed);

	public void speedDown(int speed);
}

class Car implements InterB {
	int curSpeed = SPEED; // 초기값 100 대입

	@Override
	public void speedWrite() {
		System.out.println("현재 속도: " + curSpeed);
	}

	@Override
	public void speedUp(int speed) {
		System.out.println("스피드를 " + speed + "만큼 올립니다");
		curSpeed += speed;
	}

	@Override
	public void speedDown(int speed) {
		System.out.println("스피드를 " + speed + "만큼 내립니다");
		curSpeed -= speed;
	}

}

public class Ex10Interface {

	public static void main(String[] args) {
		InterB inter = new Car();
		inter.speedWrite();
		inter.speedUp(30);
		inter.speedWrite();
		inter.speedDown(50);
		inter.speedWrite();
	}

}
