package day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
 * Set 인터페이스를 구현한 클래스: HashSet, TreeSet
 * 특징
 * 1. 중복 데이터 허용 X
 * 2. 비순차적 - 추가한 순서대로 들어가지 않음
 *    HashSet: 임의로 정해짐
 *    TreeSet: 오름차순으로 정해짐
 *    
 * 모든 컬렉션 타입(Set, Map, List) - 제네릭을 이용해 타입을 지정
 * -> 원래 Object 타입만 추가되는데 
 *    jdk5 이후로 autoBoxing에 의해 기본형도 자동으로 객체화돼서 들어간다.
 */

public class Ex4Set {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(); // 우측 제네릭스 부분은 타입 생략 가능
		Set<Integer> set2 = new TreeSet<Integer>();

		set1.add(100);
		set1.add(300);
		set1.add(100);
		set1.add(200);
		set1.add(500);

		set2.add(100);
		set2.add(300);
		set2.add(100);
		set2.add(200);
		set2.add(500);

		// Set - 중복 허용 X
		System.out.println("set1의 갯수: " + set1.size());
		System.out.println("set2의 갯수: " + set2.size());

		// 출력
		System.out.println("HashSet 결과");
		for (Integer n : set1)
			System.out.print(n + " "); // 비순차적
		System.out.println();

		System.out.println("TreeSet 결과");
		for (Integer n : set2)
			System.out.print(n + " "); // 오름차순
		System.out.println();
	}

}
