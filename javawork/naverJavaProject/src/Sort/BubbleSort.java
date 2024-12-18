package Sort;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		int leng = arr.length;
		boolean swapped;

		for (int i = 0; i < leng - 1; i++) {
			swapped = false;
			for (int j = 0; j < leng - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}
}
