package day1218;

class Car2 {
	String company = "현대";
	String model = "그랜저";
	String color = "black";
	int maxSpeed = 350;
	int speed;
}

public class Book219 {

	public static void main(String[] args) {
		// 교재 219 - 필드값 변경
		Car2 myCar = new Car2();

		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("차량색: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);

		myCar.speed = 60;
		System.out.println("현재속도(New): " + myCar.speed);

	}

}
