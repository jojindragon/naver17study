package day1224;

import java.util.Arrays;
import java.util.List;

public class Ex10ListVector {

	public static void main(String[] args) {
		// Arrays를 이용한 List 값 넣기
		List<String> list1 = Arrays.asList("장미꽃", "안개꽃", "국화꽃", "다알리아");
		System.out.println("list1의 크기: " + list1.size());

		List<Integer> list2 = Arrays.asList(56, 78, 99, 100, 80);
		System.out.println("list2의 크기: " + list2.size());
		System.out.println();

		// 츌력
		System.out.print("list1 출력: ");
		for (String s : list1)
			System.out.print(s + " ");
		System.out.println();

		System.out.print("list2 출력: ");
		for (int i : list2)
			System.out.print(i + " ");
		System.out.println();
	}

}
