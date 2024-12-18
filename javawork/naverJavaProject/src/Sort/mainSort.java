package Sort;

import java.util.Scanner;

public class mainSort {

	public static void main(String[] args) {
		// 0. 종료 1. 버블 2. 선택 3. 삽입 4. 퀵 5. 병합
		// 6. 힙
		Scanner sc = new Scanner(System.in);

		System.out.println("정렬 프로그램");
		System.out.println("0. 종료 1. 버블 2. 선택 3. 삽입 4. 퀵 5. 병합");
		System.out.println("6. 힙");
		System.out.println("=".repeat(30));

		int num;
		Exit: while (true) {
			int[] data = { 4, 1, 5, 3, 2, 9, 10, 6, 8, 0, 7 };

			num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 0 -> {
				break Exit;
			}

			case 1 -> {
				BubbleSort.bubbleSort(data);
				System.out.println("== 버블 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			case 2 -> {
				SelectionSort.selectionSort(data);
				System.out.println("== 선택 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			case 3 -> {
				InsertionSort.insertionSort(data);
				System.out.println("== 삽입 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			case 4 -> {
				QuickSort.quickSort(data, 0, data.length - 1);
				System.out.println("== 퀵 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			case 5 -> {
				MergeSort.mergeSort(data, 0, data.length - 1);
				System.out.println("== 병합 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			case 6 -> {
				HeapSort.heapSort(data);
				System.out.println("== Heap 정렬 ==");
				for (int n : data)
					System.out.print(n + " ");
				break;
			}

			default -> {
				break Exit;
			}
			}
			System.out.println();
		}
	}

}
