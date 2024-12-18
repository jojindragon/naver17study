package day1218;

class Car {
	static String carCompany = "현대";

	private String carName;
	private int carPrice;

	public static void setCarCompany(String carCompany) {
		// static 메서드에서는 static 변수만이 접근 가능
		Car.carCompany = carCompany;
	}

	// setter
	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	// getter
	public String getCarName() {
		return carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setData(String carName, int carPrice) {
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}

}

public class Ex9Object {
	public static void writeCarInfo(Car myCar) {
		System.out.println("자동차명 : " + myCar.getCarName());
		System.out.println("가격 : " + myCar.getCarPrice());
		System.out.println("=".repeat(30));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("자동차 회사명: " + Car.carCompany);
		Car.setCarCompany("라이라이 차차차");
		System.out.println("변경된 회사명: " + Car.carCompany);

		Car c1 = new Car();
		c1.setCarName("오도방구");
		c1.setCarPrice(0);

		Car c2 = new Car();
		c2.setData("스까불릿", -100);
		
		Car c3 = new Car();
		c3.setCarName("Mini");
		c3.setCarPrice(5000);
		
		writeCarInfo(c1);
		writeCarInfo(c2);
		writeCarInfo(c3);

	}

}
