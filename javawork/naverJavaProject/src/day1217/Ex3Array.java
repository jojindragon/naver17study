package day1217;

public class Ex3Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[5];
		arr1[0] = 23;
		arr1[3] = 30;

		for (int i = 0; i < arr1.length; i++)
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		System.out.println("=".repeat(20));

		int[] arr2 = new int[5];
		arr2 = new int[] { 23, 45, 56, 11, 29 };

		for (int i = 0; i < arr2.length; i++)
			System.out.println("arr1[" + i + "] = " + arr2[i]);
		System.out.println("=".repeat(20));

		int[] arr3 = { 90, 100, 110, 89, 45 };

		for (int i : arr3)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("=".repeat(20));

	}

}
