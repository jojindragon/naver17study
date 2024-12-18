package day1218;

import java.text.NumberFormat;

public class Ex10Object {

	public static void showTitle() {
		System.out.println("번호\t자동차명\t가격");
		System.out.println("=".repeat(30));
	}

	public static void writeCar(int num, Car myCar) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(num + "\t" + myCar.getCarName() + "\t" + nf.format(myCar.getCarPrice()) + "원");
	}

	public static void main(String[] args) {
		// 객체 배열
		// 메모리 할당 시 무조건 초기값 = Null -> 메모리 할당만 한 거
		Car[] cars = new Car[5];
		// Null인 상태에서 메서드 호출 시 Exception
//		cars[0].setData("그랜져", 55000); 
		// 그러므로 따로 각 객체를 생성
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
		}

		cars[0].setData("그랜져", 95000);
		cars[1].setData("바루스", 55670);
		cars[2].setData("Mini", 80000);
		cars[3].setData("오도방구", 10000);
		cars[4].setData("라이 차", 10000);

		showTitle();
		for (int i = 0; i < cars.length; i++)
			writeCar(i + 1, cars[i]);
		System.out.println();
		
		// 다른 방법 출력
		int n = 0;
		for (Car car : cars)
			writeCar(++n, car);
	}

}
