package Sort;

public class MergeSort {
	private static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;

		int[] Left = new int[n1];
		int[] Right = new int[n2];

		for (int i = 0; i < n1; i++)
			Left[i] = arr[l + i];

		for (int j = 0; j < n2; j++)
			Right[j] = arr[mid + 1 + j];

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (Left[i] <= Right[j])
				arr[k++] = Left[i++];
			else
				arr[k++] = Right[j++];
		}

		while (i < n1)
			arr[k++] = Left[i++];
		while (j < n2)
			arr[k++] = Right[j++];

	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
}
