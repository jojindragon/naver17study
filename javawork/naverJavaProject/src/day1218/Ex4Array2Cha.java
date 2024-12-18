package day1218;

public class Ex4Array2Cha {

	public static void main(String[] args) {
		// 2차원 배열에 선언 시 초기화
		int[][] arr1 = { { 67, 78, 90 }, 
				{ 21, 22 }, 
				{ 100, 98, 100, 90 } };

		System.out.println("행: " + arr1.length);
		System.out.println("0번행 열: " + arr1[0].length);
		System.out.println("1번행 열: " + arr1[1].length);
		System.out.println("2번행 열: " + arr1[2].length);

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
