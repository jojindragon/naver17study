package day1219;

public class Book235 {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		myCalc.powerOn();

		int x = 5, y = 6;
		int result1 = myCalc.plus(x, y);
		double result2 = myCalc.divide(x, y);

		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);

		myCalc.powerOff();

	}

}
