package day1217;

public class Ex15ArrayRandom {

	public static void main(String[] args) {
		// 배열에 랜덤(1~50)으로 수를 받고 이것을 오름차순 정렬
		int[] num = new int[20];
//		boolean[] used = new boolean[50];

		// 난수 생성 - 이전에 발생한 값일 경우 중복 처리 - 다시 구하기
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 50) + 1;
			for (int j = 0; j < i; j++) {
				if (num[i] == num[j]) {
					i--;
					break;
				}
			}
			
//			int n = (int) (Math.random() * 50) + 1;
//			if (!used[n - 1]) {
//				num[i] = n;
//				used[n - 1] = true;
//			} else {
//				i--;
//			}
		}

		// 정렬
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}

		// 출력
		for (int i = 0; i < num.length; i++) {
			System.out.printf("%d: %2d\t", i, num[i]);
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
	}

}
