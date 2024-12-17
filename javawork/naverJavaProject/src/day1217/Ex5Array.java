package day1217;

public class Ex5Array {

	public static void main(String[] args) {
		// 최대&최소 값 구하기
		int[] data = { 23, 100, 240, -24, -2, 11, 0, 24, 50, -37 };
		int max, min;
		max = data[0];
		min = data[0];
		for (int i = 1; i < data.length; i++) {
			if (max < data[i])
				max = data[i];

			if (min > data[i])
				min = data[i];
		}
		System.out.println("최댓값: "+max+", 최솟값: "+min);

	}

}
