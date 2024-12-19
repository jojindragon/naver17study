package Sort;

public class RadixSort {

	private static void countingSortByDigit(int[] arr, int xp) {
		int n = arr.length;
		int[] output = new int[n];
		int[] cnt = new int[10];

		// 현재 자릿수 값 계산
		for (int i = 0; i < n; i++) {
			int digit = arr[i] / xp % 10;
			cnt[digit]++;
		}

		// 누적합 계산
		for (int i = 1; i < 10; i++)
			cnt[i] += cnt[i - 1];

		// 결과 배열 구성
		for (int i = n - 1; i >= 0; i--) {
			int digit = arr[i] / xp % 10;
			output[cnt[digit] - 1] = arr[i];
			cnt[digit]--;
		}

		// 원본 배열 갱신
		for (int i = 0; i < n; i++)
			arr[i] = output[i];

	}

	private static int getMax(int[] arr) {
		int max = arr[0];
		for (int num : arr)
			if (num > max)
				max = num;

		return max;
	}

	public static void radixSort(int[] arr) {
		int max = getMax(arr);
		for (int xp = 1; max / xp > 0; xp *= 10) {
			countingSortByDigit(arr, xp);
		}
	}

}
