package day1224;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex6SetLotto {

	public static void main(String[] args) {
		// Set을 이용해 로또 구현
		Scanner sc = new Scanner(System.in);
		int money;

		try {
			System.out.print("로또를 구입할 금액: ");
			money = Integer.parseInt(sc.nextLine());
			if (money < 1000) {
				System.out.println("금액 부족");
				return;
			}

			for (int i = 0; i < money / 1000; i++) {
				Set<Integer> setLotto = new TreeSet<Integer>();
				System.out.print(i + 1 + "회: ");

				while (true) {
					int n = (int) (Math.random() * 45) + 1;
					setLotto.add(n);
					if (setLotto.size() == 6)
						break;
				}

				for (Integer lotto : setLotto)
					System.out.printf("%3d", lotto);
				System.out.println();
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력! : " + e.getMessage());
		}

	}

}
