package day1212;

import java.util.Scanner;

public class EX13If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x, y, max;
		System.out.println("두 수를 입력");
		x = sc.nextInt();
		y = sc.nextInt();

		if (x > y)
			max = x;
		else
			max = y;

		System.out.println("더 큰 수: " + max);
	}

}
