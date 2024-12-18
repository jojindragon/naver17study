package day1218;

class Car1 {
	String model;
	boolean start;
	int speed;
}

public class Book217 {

	public static void main(String[] args) {
		// 교재 217 - 초기값 보기
		Car1 myCar = new Car1();

		System.out.println("모델명: " + myCar.model);
		System.out.println("시동여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
	}

}
