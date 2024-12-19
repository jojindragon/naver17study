package day1219;

public class Ex10MyCarArray {

	public static void showTitle() {
		System.out.println("차명\t가격\t색깔\t구매일");
		System.out.println("=".repeat(50));
	}

	public static void writeMyCar(MyCar myCar) {
		System.out.println(
				myCar.getName() + "\t" + myCar.getPrice() + "\t" + myCar.getColor() + "\t" + myCar.getPurchaseDay());
	}

	public static void main(String[] args) {
		MyCar my1 = new MyCar();
		System.out.println(my1); // toString이 있을 경우 자동 호출

		MyCar my2 = new MyCar("소나타", "진주색", 3900);
		System.out.println(my2);

		System.out.println("객체 배열 생성");
//		MyCar[] carArray = { new MyCar(), new MyCar("그랜저", "black", 5600), new MyCar("BMW", "white", 6700) };
		MyCar[] carArray = new MyCar[3];
		carArray[0] = new MyCar();
		carArray[1] = new MyCar("그랜저", "black", 5600);
		carArray[2] = new MyCar("BMW", "white", 6700);
		System.out.println();

		// 제목 출력
		showTitle();

		// for 문으로 데이터 출력
		for (MyCar c : carArray)
			writeMyCar(c);

	}
}