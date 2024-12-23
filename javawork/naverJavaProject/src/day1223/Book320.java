package day1223;

class Vehicle {
	public void run() {
		System.out.println("차량이 달리다.");
	}
}

class Bus extends Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달리다.");
	}
}

class Taxi extends Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달리다.");
	}
}

class Driver {
	public void driver(Vehicle vehicle) {
		vehicle.run();
	}
}

public class Book320 {

	public static void main(String[] args) {
		// 교재 320 ~ 322 - 매개변수 다형성
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.driver(bus);
		driver.driver(taxi);

	}

}
