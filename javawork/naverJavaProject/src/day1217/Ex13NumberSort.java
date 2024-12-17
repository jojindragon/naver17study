package day1217;

public class Ex13NumberSort {

	public static void main(String[] args) {
		int[] data = { 4, 1, 5, 3, 2, 9, 10, 6, 8, 0, 7 };
		// 선택 정렬 - selection sort
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}

		for (int i = 0; i < data.length; i++) {
			System.out.println(i + ": " + data[i]);
		}
	}

}
