package Sort;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
		int leng = arr.length;
		for (int i = 0; i < leng - 1; i++) {
			int midIndex = i;
			for (int j = i + 1; j < leng; j++) {
				if (arr[j] < arr[midIndex]) {
					midIndex = j;
				}
			}
			int temp = arr[midIndex];
			arr[midIndex] = arr[i];
			arr[i] = temp;

		}
	}
}
