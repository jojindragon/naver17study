package day1210;

public class Ex2Args {

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println("일반적인 합: " + args[0] + args[1]);

		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		System.out.println("형변환 이후 합: " + (su1 + su2));

	}

}
