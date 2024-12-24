package day1224;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex9ListVector {

	public static void main(String[] args) {
		List<String> list1 = new Vector<String>(); // 기본 10개 할당, 10개씩 증가
		List<String> list2 = new Vector<String>(5, 3); // 5개 할당, 3개씩 증가

		// size() - 요소의 개수
		System.out.println("list1 데이터 개수: " + list1.size());
		// capacity() - 할당 크기, 오버라이드 메소드 X (캐스팅 필요)
		System.out.println("list1 할당 크기: " + ((Vector<String>) list1).capacity());

		System.out.println("list2 데이터 개수: " + list2.size());
		System.out.println("list2 할당 크기: " + ((Vector<String>) list2).capacity());
		System.out.println("=".repeat(15));

		list2.add("김상아");
		list2.add("이미자");
		list2.add("강호동");
		list2.add("이진");
		list2.add("김상아");
		list2.add("미선");
		list2.add("리워드");

		System.out.println("list2 데이터 개수: " + list2.size());
		System.out.println("list2 할당 크기: " + ((Vector<String>) list2).capacity());

		System.out.println("출력 방법1");
		for (String s : list2)
			System.out.print(s + " ");
		System.out.println();

		System.out.println("출력 방법2");
		for (int i = 0; i < list2.size(); i++)
			System.out.print(i + 1 + ":" + list2.get(i) + " ");
		System.out.println();

		System.out.println("출력 방법3");
		Iterator<String> iter = list2.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println();

		System.out.println("출력 방법4");
		Object[] ob = list2.toArray();
		for (Object s : ob)
			System.out.print(s + " ");

	}

}
