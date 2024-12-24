package day1224;

//abstract class Vehicle {
//	abstract public void run();
//}
interface Vehicle {
	public void run();
}

// class Bus extends Vehicle {
class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달리다.");
	}
}

// class Taxi extends Vehicle { 
class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달리다.");
	}
}

class Driver {

	// 매개변수 다형성
	public void driver(Vehicle vehicle) {
		vehicle.run();
	}
}

public class Book322 {

	public static void main(String[] args) {
		// 교재 320 ~ 322 - 매개변수 다형성
		Driver driver = new Driver();

		Bus bus = new Bus();
		Taxi taxi = new Taxi();

		driver.driver(bus);
		driver.driver(taxi);

	}

}
