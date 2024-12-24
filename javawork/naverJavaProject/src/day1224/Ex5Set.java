package day1224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex5Set {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new TreeSet<String>();

		set1.add("강리나");
		set1.add("이홍기");
		set1.add("강리나");
		set1.add("이영자");

		set2.add("강리나");
		set2.add("이홍기");
		set2.add("강리나");
		set2.add("이영자");

		System.out.println("set1의 갯수: " + set1.size());
		System.out.println("set2의 갯수: " + set2.size());

		System.out.println("HashSet 출력");
		for (String s : set1)
			System.out.print(s + " "); // 비순차적
		System.out.println();

		System.out.println("TreeSet 출력");
		for (String s : set2)
			System.out.print(s + " "); // 오름차순
		System.out.println();

		// Iterator
		Iterator<String> iter = set2.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
	}

}
