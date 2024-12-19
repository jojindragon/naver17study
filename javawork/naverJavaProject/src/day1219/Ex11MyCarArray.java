package day1219;

import java.util.Scanner;

public class Ex11MyCarArray {

	public static void showTitle() {
		System.out.println("차명\t가격\t색깔\t구매일");
		System.out.println("=".repeat(50));
	}

	public static void writeMyCar(MyCar myCar) {
		System.out.println(
				myCar.getName() + "\t" + myCar.getPrice() + "\t" + myCar.getColor() + "\t" + myCar.getPurchaseDay());
	}

	public static void main(String[] args) {
		// 입력할 갯수를 입력 후 메모리 할당
		Scanner sc = new Scanner(System.in);
		MyCar[] myCar;
		int cnt;

		System.out.print("등록할 자동차 갯수: ");
		cnt = Integer.parseInt(sc.nextLine());
		myCar = new MyCar[cnt];

		for (int i = 0; i < cnt; i++) {
			System.out.print("자동차명: ");
			String name = sc.nextLine();
			System.out.print("차량 색: ");
			String color = sc.nextLine();
			System.out.print("가격: ");
			int price = Integer.parseInt(sc.nextLine());

			myCar[i] = new MyCar(name, color, price);
			System.out.println("-".repeat(15));
		}

		showTitle();
		for (MyCar c : myCar)
			writeMyCar(c);

	}

}
